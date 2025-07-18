CREATE DATABASE IF NOT EXISTS studydb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE studydb;

CREATE TABLE users(
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      user_id VARCHAR(50) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      name VARCHAR(100),
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE studies(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(200) NOT NULL,
                        description TEXT,
                        max_members INT NOT NULL,
                        deadline DATETIME,
                        author VARCHAR(50) NOT NULL,
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE applications(
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             study_id INT NOT NULL,
                             user_id VARCHAR(50) NOT NULL,
                             applied_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                             UNIQUE KEY uc_study_user(study_id, user_id),
                             FOREIGN KEY (study_id) REFERENCES studies(id)
);
