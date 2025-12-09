package com.gtd.profile.controller;

import com.gtd.profile.entity.Profile;
import com.gtd.profile.entity.User;
import com.gtd.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.gtd.profile.respository.UserRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    @Autowired
    private com.gtd.profile.respository.UserRepository userRepository;

    @GetMapping("/my-profile")
    public String myProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getName())) {
            return "redirect:/login";
        }

        String username = auth.getName();
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            return "redirect:/login";
        }
        
        User user = userOpt.get();
        Optional<Profile> profileOpt = profileService.getProfileByUser(user);
        
        if (profileOpt.isPresent()) {
            model.addAttribute("profile", profileOpt.get());
        } else {
            Profile newProfile = new Profile(user);
            model.addAttribute("profile", newProfile);
        }
        
        model.addAttribute("isOwner", true);
        return "profile";
    }

    @PostMapping("/update")
    public String updateProfile(@ModelAttribute Profile profileData,
                                @RequestParam(value = "avatarFile", required = false) MultipartFile avatarFile,
                                @RequestParam(value = "coverFile", required = false) MultipartFile coverFile) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getName())) {
            return "redirect:/login";
        }

        String username = auth.getName();
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            return "redirect:/login";
        }
        
        User user = userOpt.get();

        // Handle file uploads
        if (avatarFile != null && !avatarFile.isEmpty()) {
            String avatarPath = saveFile(avatarFile, "avatar_" + user.getId());
            if (avatarPath != null) {
                profileData.setAvatarPath(avatarPath);
            }
        }

        if (coverFile != null && !coverFile.isEmpty()) {
            String coverPath = saveFile(coverFile, "cover_" + user.getId());
            if (coverPath != null) {
                profileData.setCoverPath(coverPath);
            }
        }

        profileService.createOrUpdateProfile(user, profileData);
        return "redirect:/profile/my-profile";
    }

    private String saveFile(MultipartFile file, String prefix) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename != null && originalFilename.contains(".") 
                ? originalFilename.substring(originalFilename.lastIndexOf(".")) 
                : "";
            String filename = prefix + "_" + System.currentTimeMillis() + extension;
            Path filePath = uploadPath.resolve(filename);
            Files.write(filePath, file.getBytes());
            
            return "/images/" + filename;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

