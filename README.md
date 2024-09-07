
**Inventory Management System for Equipment and Software Packages**

This project is an **Inventory Management System** designed to efficiently manage and track the inventory of equipment and software packages within an organization. Built using **Java on NetBeans** as the front-end interface and **SQLite** as the back-end database, the system provides a seamless offline solution for tracking equipment details, managing software installations, and recording failure histories. The system is particularly tailored for environments where security is paramount, and manual record-keeping is cumbersome.

### Key Features:
1. **User Management**:
   - **Admin Roles**: The system supports multiple admin roles, including a super admin and other regular admins. Each user has a secure profile with personal details, username, password, and role-based access control.
   
2. **Equipment Management**:
   - **Track Equipment Details**: Allows administrators to record comprehensive details for each equipment, including serial number, asset ID, and store reference number.
   - **Failure Tracking**: The system records each instance of equipment failure, storing rectification dates and failure reports for future reference.
   - **Location-Based Management**: Each piece of equipment is assigned a specific location to aid in organizing inventory and conducting searches.

3. **Software Package Management**:
   - **Software Tracking**: Admins can manage details of installed software on each piece of equipment, including software name, version number, size, and installation location.
   - **Version Control**: The system tracks multiple versions of software installed across different equipment for easier management and updates.

4. **Failure History and Maintenance Records**:
   - **History Card**: A history card is generated for each equipment, detailing failure dates, rectification timelines, and relevant comments. This ensures that maintenance schedules and failure patterns are meticulously logged.

5. **Search and Query**:
   - **Intelligent Search**: The system includes search functionality allowing users to search for equipment and software using various parameters like ID, serial number, failure records, and location.
   - **Compliance with Query Parsing and Chatbot Repository**: The system works in compliance with a query parsing module and chatbot repository, enabling it to understand and respond to complex user queries through natural language, making it easier for users to interact with the system intuitively.

6. **AI Integration (Future Enhancement)**:
   - **AI-Powered Queries**: In later stages, the system will integrate AI to understand and parse user queries, providing relevant results based on natural language input.

### Technical Stack:
- **Front-End**: Java (NetBeans IDE)
- **Back-End**: SQLite Database
- **Database Structure**:
  - **User Table**: Stores admin details with role-based access.
  - **Equipment Table**: Records information related to equipment inventory.
  - **Software Package Table**: Manages software installed across various equipment.
  - **History Card Table**: Logs failure and rectification information for each equipment.

This **Inventory Management System** offers a robust, secure, and user-friendly solution for managing equipment and software packages. Its offline operation ensures heightened security, while the streamlined interface and integration with a **query parsing and chatbot repository** enhance user experience by allowing intelligent interactions and queries.
