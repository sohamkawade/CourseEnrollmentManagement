# Course Enrollment Management System

# Technologies: Java, JDBC, MySQL

# Description: 
A console-based Java application for managing student course enrollments.
Supports CRUD operations (Create, Read, Update, Delete) using JDBC with MySQL database.

# Features:
Add, view, update, and delete student enrollments

Secure database operations using prepared statements

Console-based interface with exception handling

Tracks course status as Active or Completed


# Table Structure:
CREATE DATABASE javadb;

USE javadb;

CREATE TABLE courseEnrollments(
	enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL UNIQUE,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    course_name VARCHAR(20) NOT NULL,
    enrollment_date DATE NOT NULL DEFAULT NOW(),
    course_duration INT NOT NULL CHECK (course_duration>0),
    course_status ENUM("Active","Completed") DEFAULT "Active"    
);

# Sample Console Output:

*** Course Enrollment Management ***
Add Enrollment:1
View Enrollment:2
Update Enrollment:3
Delete Enrollment:4
Exit:5
-------------------------------------------------------
Enter number to perform CRUD operation:1
Enter student id:110
Enter student firstname:Soham
Enter student lastname:Kawade
Enter course name:Python Full stack
Enter course duration in months:6
data inserted!
Enter number to perform CRUD operation:2
e_id | s_id | firstname | lastname | c_name | e_date | c_duration | c_status
----------------------------------------------------------------------------
8 | 101 | Tushar | Nikam | Java Full Stack | 2025-09-24 | 6 | Active
11 | 110 | Soham | Kawade | Python Full stack | 2025-09-24 | 6 | Active
Enter number to perform CRUD operation:3
Enter student id you want to update:101
Enter student firstname:Tushar
Enter student lastname:Nikam
Enter course name:Data Science
Enter course duration in months:4
data updated!
Enter number to perform CRUD operation:4
Enter student id you want to delete:110
data deleted!
Enter number to perform CRUD operation:2
e_id | s_id | firstname | lastname | c_name | e_date | c_duration | c_status
----------------------------------------------------------------------------
8 | 101 | Tushar | Nikam | Data Science | 2025-09-24 | 4 | Active
Enter number to perform CRUD operation:5
Exited!
