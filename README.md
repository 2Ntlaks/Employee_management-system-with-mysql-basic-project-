# EmployeePortal

Employee Portal is a Java-based application that allows you to manage employee records. The application interacts with a MySQL database to perform operations such as adding, displaying, updating, and deleting employee details.

## Features

- **Add Employee** : Add new employees to the database without needing an ID.
- **Display Employees** : Display all employees or search for an employee by ID.
- **Update Employee** : Update the department or address of an existing employee.
- **Delete Employee** : Remove an employee from the database using their ID.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed on your machine.
- MySQL installed and running.
- Git installed on your machine.
- A MySQL database with a `profile` table that has the following structure:

  ```sql command
  CREATE TABLE profile (
      name VARCHAR(50),
      surname VARCHAR(50),
      id INT AUTO_INCREMENT PRIMARY KEY,
      department VARCHAR(50),
      address VARCHAR(100)
  );
  ```
