package com.gtd.profile.respository;

import com.gtd.profile.entity.Media;
import com.gtd.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByProfile(Profile profile);
    List<Media> findByProfileAndMediaType(Profile profile, String mediaType);
    List<Media> findByProfileAndPrivacy(Profile profile, String privacy);
}

