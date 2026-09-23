# FamBase: Presentation
Family planner app.

## Purpose
For when texting each other is not enough and you need a place to sort your ideas and plans as a family/group, FamBase is an app that makes communication easier. 

## Features
1. Shared events system
2. Shared shopping list
3. Shared task/chores list

## User Stories
1. As a admin, i can add other users to my Family.
2. As a user(or admin), i can add, remove, and modify tasks.
3. As a user(or admin), i can view tasks grouped by category.
4. As a user(or admin), i can add, remove, and modify shopping items in a list.
5. As a user(or admin), i can view shopping items grouped by category.
6. As a user(or admin), i can add and remove events, and view them in a list form.
7. As a user(or admin), i can create an account and log into it.
8. As a user(or admin), i can set an avatar image.
9. As a user(or admin), i can change my username.


## Running instructions

### download the file:
```bash
git clone https://github.com/teiutz/FamBase.git
```

### enter project root:
```bash
cd FamBase
```

### build and start everything
```bash
docker compose up --build
```

### Then open in a browser:
`http://localhost:8080`

# Relevant Files Structure
```
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 com
│   │   │       └── 📁 tea
│   │   │           └── 📁 fambase
│   │   │               ├── 📁 bootstrap
│   │   │               │   └── ☕ DataLoader.java
│   │   │               ├── 📁 controllers
│   │   │               │   ├── ☕ AdminController.java
│   │   │               │   ├── ☕ AllController.java
│   │   │               │   ├── ☕ EventController.java
│   │   │               │   ├── ☕ FamilyMembersController.java
│   │   │               │   ├── ☕ HomeController.java
│   │   │               │   ├── ☕ RegisterController.java
│   │   │               │   ├── ☕ ShoppingItemController.java
│   │   │               │   ├── ☕ TaskController.java
│   │   │               │   ├── ☕ UpdateUserController.java
│   │   │               │   └── ☕ UserController.java
│   │   │               ├── 📁 domain
│   │   │               │   ├── ☕ AvatarImage.java
│   │   │               │   ├── ☕ Category.java
│   │   │               │   ├── ☕ Event.java
│   │   │               │   ├── ☕ Family.java
│   │   │               │   ├── ☕ Role.java
│   │   │               │   ├── ☕ ShoppingItem.java
│   │   │               │   ├── ☕ Task.java
│   │   │               │   ├── ☕ TaskType.java
│   │   │               │   └── ☕ User.java
│   │   │               ├── 📁 repository
│   │   │               │   ├── ☕ AvatarImageRepository.java
│   │   │               │   ├── ☕ EventRepository.java
│   │   │               │   ├── ☕ FamilyRepository.java
│   │   │               │   ├── ☕ ShoppingItemRepository.java
│   │   │               │   ├── ☕ TaskRepository.java
│   │   │               │   └── ☕ UserRepository.java
│   │   │               ├── 📁 security
│   │   │               │   ├── ☕ SecurityConfig.java
│   │   │               │   └── ☕ UserRepoUserDetailsService.java
│   │   │               ├── 📁 services
│   │   │               │   ├── ☕ EventService.java
│   │   │               │   ├── ☕ FamilyService.java
│   │   │               │   ├── ☕ ShoppingItemService.java
│   │   │               │   ├── ☕ TaskService.java
│   │   │               │   └── ☕ UserService.java
│   │   │               └── ☕ FirstMvcApplication.java
│   │   └── 📁 resources
│   │       ├── 📁 templates
│   │       │   ├── 📁 account
│   │       │   │   ├── 🌐 admin.html
│   │       │   │   ├── 🌐 login.html
│   │       │   │   └── 🌐 register.html
│   │       │   ├── 📁 events
│   │       │   │   ├── 🌐 addevents.html
│   │       │   │   ├── 🌐 events.html
│   │       │   │   └── 🌐 eventssave.html
│   │       │   ├── 📁 family
│   │       │   │   └── 🌐 getMembers.html
│   │       │   ├── 📁 fragments
│   │       │   │   └── 🌐 general.html
│   │       │   ├── 📁 general
│   │       │   │   ├── 🌐 all.html
│   │       │   │   ├── 🌐 all_th.html
│   │       │   │   ├── 🌐 error.html
│   │       │   │   └── 🌐 index.html
│   │       │   ├── 📁 shopping-items
│   │       │   │   ├── 🌐 addshoppingItems.html
│   │       │   │   ├── 🌐 groupedShoppingItems.html
│   │       │   │   ├── 🌐 shopping-list.html
│   │       │   │   └── 🌐 updateshoppingitems.html
│   │       │   ├── 📁 tasks
│   │       │   │   ├── 🌐 addtasks.html
│   │       │   │   ├── 🌐 chores.html
│   │       │   │   ├── 🌐 groupedTasks.html
│   │       │   │   └── 🌐 updatechores.html
│   │       │   └── 📁 users
│   │       │       ├── 🌐 adduser.html
│   │       │       ├── 🌐 changeUsername.html
│   │       │       └── 🌐 showusers.html
│   │       └── 📄 application.properties
│   └── 📁 test
│       └── 📁 java
│           └── 📁 com
│               └── 📁 tea
│                   └── 📁 fambase
│                       └── ☕ FirstMvcApplicationTests.java
```

