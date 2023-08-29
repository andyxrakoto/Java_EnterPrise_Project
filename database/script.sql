CREATE DATABASE entreprise;

-- \c entreprise;

-- Creating the "Departments" table
CREATE TABLE Departments (
    ID INT PRIMARY KEY,
    DepartmentName VARCHAR(255),
    Description VARCHAR(255)
);

-- Creating the "Employees" table
CREATE TABLE Employees (
    ID INT PRIMARY KEY,
    LastName VARCHAR(255),
    FirstName VARCHAR(255),
    DateOfBirth DATE,
    Address VARCHAR(255),
    PhoneNumber VARCHAR(15),
    EmailAddress VARCHAR(255),
    HireDate DATE,
    JobTitle VARCHAR(255),
    Salary FLOAT,
    DepartmentID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Departments(ID)
);

-- Creating the "Leaves" table
CREATE TABLE Leaves (
    ID INT PRIMARY KEY,
    EmployeeID INT,
    StartDate DATE,
    EndDate DATE,
    LeaveReason VARCHAR(255),
    LeaveStatus VARCHAR(255),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(ID)
);