package com.gtd.profile.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // Thông tin cơ bản
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "avatar_path")
    private String avatarPath;

    @Column(name = "cover_path")
    private String coverPath;

    // Thông tin chi tiết
    @Column(name = "school")
    private String school;

    @Column(name = "workplace")
    private String workplace;

    @Column(name = "location")
    private String location;

    @Column(name = "hometown")
    private String hometown;

    @Column(name = "marital_status")
    private String maritalStatus; // Single, Married, In a relationship, etc.

    @Column(name = "languages")
    private String languages; // Comma-separated

    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills; // Comma-separated or JSON

    @Column(name = "awards", columnDefinition = "TEXT")
    private String awards; // Comma-separated or JSON

    @Column(name = "achievements", columnDefinition = "TEXT")
    private String achievements; // Comma-separated or JSON

    @Column(name = "links", columnDefinition = "TEXT")
    private String links; // JSON array of links

    // Privacy settings (sẽ tách ra entity riêng sau)
    @Column(name = "bio_privacy")
    private String bioPrivacy = "PUBLIC"; // PUBLIC, PRIVATE, HIDDEN

    @Column(name = "school_privacy")
    private String schoolPrivacy = "PUBLIC";

    @Column(name = "workplace_privacy")
    private String workplacePrivacy = "PUBLIC";

    @Column(name = "location_privacy")
    private String locationPrivacy = "PUBLIC";

    @Column(name = "hometown_privacy")
    private String hometownPrivacy = "PUBLIC";

    @Column(name = "marital_status_privacy")
    private String maritalStatusPrivacy = "PUBLIC";

    @Column(name = "languages_privacy")
    private String languagesPrivacy = "PUBLIC";

    @Column(name = "skills_privacy")
    private String skillsPrivacy = "PUBLIC";

    @Column(name = "awards_privacy")
    private String awardsPrivacy = "PUBLIC";

    @Column(name = "achievements_privacy")
    private String achievementsPrivacy = "PUBLIC";

    @Column(name = "links_privacy")
    private String linksPrivacy = "PUBLIC";

    public Profile() {
    }

    public Profile(User user) {
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    // Privacy getters and setters
    public String getBioPrivacy() {
        return bioPrivacy;
    }

    public void setBioPrivacy(String bioPrivacy) {
        this.bioPrivacy = bioPrivacy;
    }

    public String getSchoolPrivacy() {
        return schoolPrivacy;
    }

    public void setSchoolPrivacy(String schoolPrivacy) {
        this.schoolPrivacy = schoolPrivacy;
    }

    public String getWorkplacePrivacy() {
        return workplacePrivacy;
    }

    public void setWorkplacePrivacy(String workplacePrivacy) {
        this.workplacePrivacy = workplacePrivacy;
    }

    public String getLocationPrivacy() {
        return locationPrivacy;
    }

    public void setLocationPrivacy(String locationPrivacy) {
        this.locationPrivacy = locationPrivacy;
    }

    public String getHometownPrivacy() {
        return hometownPrivacy;
    }

    public void setHometownPrivacy(String hometownPrivacy) {
        this.hometownPrivacy = hometownPrivacy;
    }

    public String getMaritalStatusPrivacy() {
        return maritalStatusPrivacy;
    }

    public void setMaritalStatusPrivacy(String maritalStatusPrivacy) {
        this.maritalStatusPrivacy = maritalStatusPrivacy;
    }

    public String getLanguagesPrivacy() {
        return languagesPrivacy;
    }

    public void setLanguagesPrivacy(String languagesPrivacy) {
        this.languagesPrivacy = languagesPrivacy;
    }

    public String getSkillsPrivacy() {
        return skillsPrivacy;
    }

    public void setSkillsPrivacy(String skillsPrivacy) {
        this.skillsPrivacy = skillsPrivacy;
    }

    public String getAwardsPrivacy() {
        return awardsPrivacy;
    }

    public void setAwardsPrivacy(String awardsPrivacy) {
        this.awardsPrivacy = awardsPrivacy;
    }

    public String getAchievementsPrivacy() {
        return achievementsPrivacy;
    }

    public void setAchievementsPrivacy(String achievementsPrivacy) {
        this.achievementsPrivacy = achievementsPrivacy;
    }

    public String getLinksPrivacy() {
        return linksPrivacy;
    }

    public void setLinksPrivacy(String linksPrivacy) {
        this.linksPrivacy = linksPrivacy;
    }

    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        } else if (firstName != null) {
            return firstName;
        } else if (lastName != null) {
            return lastName;
        }
        return user != null ? user.getUsername() : "User";
    }
}
