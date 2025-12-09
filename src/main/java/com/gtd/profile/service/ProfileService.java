package com.gtd.profile.service;

import com.gtd.profile.entity.Profile;
import com.gtd.profile.entity.User;
import com.gtd.profile.respository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Optional<Profile> getProfileByUser(User user) {
        return profileRepository.findByUser(user);
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    @Transactional
    public Profile createOrUpdateProfile(User user, Profile profileData) {
        Optional<Profile> existingProfile = profileRepository.findByUser(user);
        
        if (existingProfile.isPresent()) {
            Profile profile = existingProfile.get();
            updateProfileFields(profile, profileData);
            return profileRepository.save(profile);
        } else {
            Profile newProfile = new Profile(user);
            updateProfileFields(newProfile, profileData);
            return profileRepository.save(newProfile);
        }
    }

    private void updateProfileFields(Profile profile, Profile profileData) {
        if (profileData.getFirstName() != null) {
            profile.setFirstName(profileData.getFirstName());
        }
        if (profileData.getLastName() != null) {
            profile.setLastName(profileData.getLastName());
        }
        if (profileData.getNickname() != null) {
            profile.setNickname(profileData.getNickname());
        }
        if (profileData.getBio() != null) {
            profile.setBio(profileData.getBio());
        }
        if (profileData.getAvatarPath() != null) {
            profile.setAvatarPath(profileData.getAvatarPath());
        }
        if (profileData.getCoverPath() != null) {
            profile.setCoverPath(profileData.getCoverPath());
        }
        if (profileData.getSchool() != null) {
            profile.setSchool(profileData.getSchool());
        }
        if (profileData.getWorkplace() != null) {
            profile.setWorkplace(profileData.getWorkplace());
        }
        if (profileData.getLocation() != null) {
            profile.setLocation(profileData.getLocation());
        }
        if (profileData.getHometown() != null) {
            profile.setHometown(profileData.getHometown());
        }
        if (profileData.getMaritalStatus() != null) {
            profile.setMaritalStatus(profileData.getMaritalStatus());
        }
        if (profileData.getLanguages() != null) {
            profile.setLanguages(profileData.getLanguages());
        }
        if (profileData.getSkills() != null) {
            profile.setSkills(profileData.getSkills());
        }
        if (profileData.getAwards() != null) {
            profile.setAwards(profileData.getAwards());
        }
        if (profileData.getAchievements() != null) {
            profile.setAchievements(profileData.getAchievements());
        }
        if (profileData.getLinks() != null) {
            profile.setLinks(profileData.getLinks());
        }
        // Update privacy settings
        if (profileData.getBioPrivacy() != null) {
            profile.setBioPrivacy(profileData.getBioPrivacy());
        }
        if (profileData.getSchoolPrivacy() != null) {
            profile.setSchoolPrivacy(profileData.getSchoolPrivacy());
        }
        if (profileData.getWorkplacePrivacy() != null) {
            profile.setWorkplacePrivacy(profileData.getWorkplacePrivacy());
        }
        if (profileData.getLocationPrivacy() != null) {
            profile.setLocationPrivacy(profileData.getLocationPrivacy());
        }
        if (profileData.getHometownPrivacy() != null) {
            profile.setHometownPrivacy(profileData.getHometownPrivacy());
        }
        if (profileData.getMaritalStatusPrivacy() != null) {
            profile.setMaritalStatusPrivacy(profileData.getMaritalStatusPrivacy());
        }
        if (profileData.getLanguagesPrivacy() != null) {
            profile.setLanguagesPrivacy(profileData.getLanguagesPrivacy());
        }
        if (profileData.getSkillsPrivacy() != null) {
            profile.setSkillsPrivacy(profileData.getSkillsPrivacy());
        }
        if (profileData.getAwardsPrivacy() != null) {
            profile.setAwardsPrivacy(profileData.getAwardsPrivacy());
        }
        if (profileData.getAchievementsPrivacy() != null) {
            profile.setAchievementsPrivacy(profileData.getAchievementsPrivacy());
        }
        if (profileData.getLinksPrivacy() != null) {
            profile.setLinksPrivacy(profileData.getLinksPrivacy());
        }
    }

    public Profile getPublicProfile(Profile profile) {
        // Filter out private/hidden fields based on privacy settings
        Profile publicProfile = new Profile();
        publicProfile.setId(profile.getId());
        publicProfile.setUser(profile.getUser());
        publicProfile.setFirstName(profile.getFirstName());
        publicProfile.setLastName(profile.getLastName());
        publicProfile.setNickname(profile.getNickname());
        publicProfile.setAvatarPath(profile.getAvatarPath());
        publicProfile.setCoverPath(profile.getCoverPath());

        if ("PUBLIC".equals(profile.getBioPrivacy())) {
            publicProfile.setBio(profile.getBio());
        }
        if ("PUBLIC".equals(profile.getSchoolPrivacy())) {
            publicProfile.setSchool(profile.getSchool());
        }
        if ("PUBLIC".equals(profile.getWorkplacePrivacy())) {
            publicProfile.setWorkplace(profile.getWorkplace());
        }
        if ("PUBLIC".equals(profile.getLocationPrivacy())) {
            publicProfile.setLocation(profile.getLocation());
        }
        if ("PUBLIC".equals(profile.getHometownPrivacy())) {
            publicProfile.setHometown(profile.getHometown());
        }
        if ("PUBLIC".equals(profile.getMaritalStatusPrivacy())) {
            publicProfile.setMaritalStatus(profile.getMaritalStatus());
        }
        if ("PUBLIC".equals(profile.getLanguagesPrivacy())) {
            publicProfile.setLanguages(profile.getLanguages());
        }
        if ("PUBLIC".equals(profile.getSkillsPrivacy())) {
            publicProfile.setSkills(profile.getSkills());
        }
        if ("PUBLIC".equals(profile.getAwardsPrivacy())) {
            publicProfile.setAwards(profile.getAwards());
        }
        if ("PUBLIC".equals(profile.getAchievementsPrivacy())) {
            publicProfile.setAchievements(profile.getAchievements());
        }
        if ("PUBLIC".equals(profile.getLinksPrivacy())) {
            publicProfile.setLinks(profile.getLinks());
        }

        return publicProfile;
    }
}

