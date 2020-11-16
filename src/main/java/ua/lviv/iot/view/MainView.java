package ua.lviv.iot.view;


import ua.lviv.iot.controller.implementation.*;
import ua.lviv.iot.model.implementation.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private final InitializationController initializationController = new InitializationController();
    private final SaveOnTopController saveOnTopController = new SaveOnTopController();
    private final SecurityController securityController = new SecurityController();
    private final StoryController storyController = new StoryController();
    private final UserController userController = new UserController();


    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    public MainView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("11", "11 - Get all initializations");
        menu.put("12", "12 - Get initialization by ID");
        menu.put("13", "13 - Create initialization");
        menu.put("14", "14 - Delete initialization by ID");
        menu.put("15", "15 - Update initialization by ID");

        menu.put("21", "21 - Get all saveOnTops");
        menu.put("22", "22 - Get saveOnTop by ID");
        menu.put("23", "23 - Create saveOnTop");
        menu.put("24", "24 - Delete saveOnTop by ID");
        menu.put("25", "25 - Update saveOnTop by ID");

        menu.put("31", "31 - Get all securities");
        menu.put("32", "32 - Get security by ID");
        menu.put("33", "33 - Create security");
        menu.put("34", "34 - Delete security by ID");
        menu.put("35", "35 - Update security by ID");

        menu.put("41", "41 - Get all stories");
        menu.put("42", "42 - Get story by ID");
        menu.put("43", "43 - Create story");
        menu.put("44", "44 - Delete story by ID");
        menu.put("45", "45 - Update story by ID");

        menu.put("51", "51 - Get all users");
        menu.put("52", "52 - Get user by ID");
        menu.put("53", "53 - Create user");
        menu.put("54", "54 - Delete user by ID");
        menu.put("55", "55 - Update user  by ID");


        methodsMenu.put("11", this::getAllInitializations);
        methodsMenu.put("12", this::getInitializationById);
        methodsMenu.put("13", this::createInitialization);
        methodsMenu.put("14", this::deleteInitializationById);
        methodsMenu.put("15", this::updateInitializationById);

        methodsMenu.put("21", this::getAllSaveOnTops);
        methodsMenu.put("22", this::getSaveOnTopById);
        methodsMenu.put("23", this::createSaveOnTop);
        methodsMenu.put("24", this::deleteSaveOnTopById);
        methodsMenu.put("25", this::updateSaveOnTopById);

        methodsMenu.put("31", this::getAllSecurities);
        methodsMenu.put("32", this::getSecurityById);
        methodsMenu.put("33", this::createSecurity);
        methodsMenu.put("34", this::deleteSecurityById);
        methodsMenu.put("35", this::updateSecurityById);

        methodsMenu.put("41", this::getAllStories);
        methodsMenu.put("42", this::getStoryById);
        methodsMenu.put("43", this::createStory);
        methodsMenu.put("44", this::deleteStoryById);
        methodsMenu.put("45", this::updateStoryById);

        methodsMenu.put("51", this::getAllUsers);
        methodsMenu.put("52", this::getUserById);
        methodsMenu.put("53", this::createUser);
        methodsMenu.put("54", this::deleteUserById);
        methodsMenu.put("55", this::updateUserById);

    }


    private void getAllInitializations() throws SQLException {
        System.out.println("\nTable: initialization");
        initializationController.getAll();
    }

    private void getInitializationById() throws SQLException {
        System.out.println("Enter ID for Initialization: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        initializationController.getById(id);
    }

    private void createInitialization() throws SQLException {
        System.out.println("Enter new initialization login: ");
        String login = INPUT.nextLine();
        System.out.println("Enter new initialization user_id: ");
        int user_id = INPUT.nextInt();
        INPUT.nextLine();
        Initialization entity = new Initialization(0, login, user_id);
        initializationController.create(entity);
    }

    private void deleteInitializationById() throws SQLException {
        System.out.println("Enter ID to delete initialization: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        initializationController.delete(id);
    }

    private void updateInitializationById() throws SQLException {
        System.out.println("Enter initialization id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Initialization oldInitialization = initializationController.getService().getById(id);
        System.out.println("Enter new initialization login: ");
        String login = INPUT.nextLine();
        System.out.println("Enter new initialization user_id: ");
        int user_id = INPUT.nextInt();
        INPUT.nextLine();

        String newLogin = login;
        Integer newUser_id = user_id;

        if (login.equals("")) newLogin = oldInitialization.getLogin();
        if (user_id < 0) newUser_id = oldInitialization.getUser_id();

        Initialization entity = new Initialization(id, newLogin, newUser_id);
        initializationController.update(entity);
    }


    //  ##################################################################################


    private void getAllSaveOnTops() throws SQLException {
        System.out.println("\nTable: saveOnTop");
        saveOnTopController.getAll();
    }

    private void getSaveOnTopById() throws SQLException {
        System.out.println("Enter ID for SaveOnTop: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        saveOnTopController.getById(id);
    }

    private void createSaveOnTop() throws SQLException {
        System.out.println("Enter new saveOnTop position: ");
        int position = INPUT.nextInt();
        System.out.println("Enter new saveOnTop status: ");
        String status = INPUT.nextLine();
        System.out.println("Enter new saveOnTop story_id: ");
        int story_id = INPUT.nextInt();
        INPUT.nextLine();
        SaveOnTop entity = new SaveOnTop(0, position, status, story_id);
        saveOnTopController.create(entity);
    }

    private void deleteSaveOnTopById() throws SQLException {
        System.out.println("Enter ID to delete SaveOnTop: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        saveOnTopController.delete(id);
    }

    private void updateSaveOnTopById() throws SQLException {
        System.out.println("Enter saveOnTop id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        SaveOnTop oldSaveOnTop = saveOnTopController.getService().getById(id);
        System.out.println("Enter new saveOnTop position: ");
        int position = INPUT.nextInt();
        System.out.println("Enter new saveOnTop status: ");
        String status = INPUT.nextLine();
        System.out.println("Enter new saveOnTop story_id: ");
        int story_id = INPUT.nextInt();
        INPUT.nextLine();

        Integer newPosition = position;
        String newStatus = status;
        Integer newStory_ID = story_id;

        if (position < 0) newPosition = oldSaveOnTop.getPosition();

        if (status.equals("")) newStatus = oldSaveOnTop.getStatus();

        if (story_id < 0) newStory_ID = oldSaveOnTop.getStory_id();


        SaveOnTop entity = new SaveOnTop(id, newPosition, newStatus, newStory_ID);
        saveOnTopController.update(entity);
    }


//  ##################################################################################


    private void getAllSecurities() throws SQLException {
        System.out.println("\nTable: security");
        securityController.getAll();
    }

    private void getSecurityById() throws SQLException {
        System.out.println("Enter ID for Security: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        securityController.getById(id);
    }

    private void createSecurity() throws SQLException {
        System.out.println("Enter new  password: ");
        String password = INPUT.nextLine();
        System.out.println("Enter new  user ID: ");
        int user_id = INPUT.nextInt();

        INPUT.nextLine();
        Security entity = new Security(0, password, user_id);
        securityController.create(entity);
    }

    private void deleteSecurityById() throws SQLException {
        System.out.println("Enter ID to delete Story: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        securityController.delete(id);
    }

    private void updateSecurityById() throws SQLException {
        System.out.println("Enter story ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Security oldSecurity = securityController.getService().getById(id);
        System.out.println("Enter new password: ");
        String password = INPUT.nextLine();
        System.out.println("Enter new user ID: ");
        int user_id = INPUT.nextInt();
        INPUT.nextLine();

        String newPassword = password;
        Integer newUserId = user_id;


        if (password.equals("")) newPassword = oldSecurity.getPassword();
        if (user_id < 0) newUserId = oldSecurity.getUser_id();


        Security entity = new Security(id, newPassword, newUserId);
        securityController.update(entity);
    }


    //  ##################################################################################


    private void getAllStories() throws SQLException {
        System.out.println("\nTable: story");
        storyController.getAll();
    }

    private void getStoryById() throws SQLException {
        System.out.println("Enter ID for Story: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        storyController.getById(id);
    }

    private void createStory() throws SQLException {
        System.out.println("Enter new bloger: ");
        String bloger = INPUT.nextLine();
        System.out.println("Enter new link: ");
        String link = INPUT.nextLine();
        System.out.println("Enter new add_time: ");
        int add_time = INPUT.nextInt();
        System.out.println("Enter new content: ");
        String content = INPUT.nextLine();
        System.out.println("Enter new like_number: ");
        int like_number = INPUT.nextInt();
        System.out.println("Enter new share_number: ");
        int share_number = INPUT.nextInt();
        INPUT.nextLine();
        Story entity = new Story(0, bloger, link, add_time, content, like_number, share_number);
        storyController.create(entity);
    }

    private void deleteStoryById() throws SQLException {
        System.out.println("Enter ID to delete Story: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        storyController.delete(id);
    }

    private void updateStoryById() throws SQLException {
        System.out.println("Enter story ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Story oldStory = storyController.getService().getById(id);
        System.out.println("Enter new bloger: ");
        String bloger = INPUT.nextLine();
        System.out.println("Enter new link: ");
        String link = INPUT.nextLine();
        System.out.println("Enter new add_time: ");
        int add_time = INPUT.nextInt();
        System.out.println("Enter new content: ");
        String content = INPUT.nextLine();
        System.out.println("Enter new like_number: ");
        int like_number = INPUT.nextInt();
        System.out.println("Enter new share_number: ");
        int share_number = INPUT.nextInt();
        INPUT.nextLine();

        String newBloger = bloger;
        String newLink = link;
        Integer newAddTime = add_time;
        String newContent = content;
        Integer newLikeNumber = like_number;
        Integer newShareNumber = share_number;

        if (bloger.equals("")) newBloger = oldStory.getBloger();
        if (link.equals("")) newLink = oldStory.getLink();
        if (add_time < 0) newAddTime = oldStory.getAdd_time();
        if (content.equals("")) newContent = oldStory.getContent();
        if (like_number < 0) newLikeNumber = oldStory.getLike_number();
        if (share_number < 0) newShareNumber = oldStory.getShare_number();

        Story entity = new Story(id, newBloger, newLink, newAddTime, newContent, newLikeNumber, newShareNumber);
        storyController.update(entity);
    }


    //  ##################################################################################


    private void getAllUsers() throws SQLException {
        System.out.println("\nTable: user");
        userController.getAll();
    }

    private void getUserById() throws SQLException {
        System.out.println("Enter ID for user: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        userController.getById(id);
    }

    private void createUser() throws SQLException {
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new birth_date: ");
        int birth_date = INPUT.nextInt();
        System.out.println("Enter new  followers: ");
        int followers = INPUT.nextInt();
        System.out.println("Enter new followings: ");
        Integer followings = INPUT.nextInt();
        System.out.println("Enter new posts: ");
        int posts = INPUT.nextInt();
        INPUT.nextLine();
        User entity = new User(0, name,birth_date,followers,followings,posts);
        userController.create(entity);
    }

    private void deleteUserById() throws SQLException {
        System.out.println("Enter ID to delete User: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        userController.delete(id);
    }

    private void updateUserById() throws SQLException {
        System.out.println("Enter user ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        User oldUser = userController.getService().getById(id);
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new birth_date: ");
        int birth_date = INPUT.nextInt();
        System.out.println("Enter new  followers: ");
        int followers = INPUT.nextInt();
        System.out.println("Enter new followings: ");
        int followings = INPUT.nextInt();
        System.out.println("Enter new posts: ");
        int posts = INPUT.nextInt();
        INPUT.nextLine();

        String newName = name;
        Integer newBirthDate = birth_date;
        Integer newFollowers = followers;
        Integer newFollowings = followings;
        Integer newPosts = posts;


        if (name.equals("")) newName = oldUser.getName();
        if (birth_date < 0) newBirthDate = oldUser.getBirth_date();
        if (followers < 0) newFollowers = oldUser.getFollowers();
        if (followings < 0) newFollowings = oldUser.getFollowings();
        if (posts < 0) newPosts = oldUser.getPosts();

        User entity = new User(id, newName,newBirthDate,newFollowers, newFollowings, newPosts);
        userController.update(entity);
    }











    //  ##################################################################################






    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = INPUT.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {
            }
        } while (!keyMenu.equals("Q"));
    }
}