package dvl.labs.datalayer;

import dvl.labs.common.User;

/**
 * Created by iura on 11/4/15.
 */
public interface DbLayer {
    /**
     * add user in db
     */
    void addUser(User user);
    /**
     * Get user details using a token
     * @param token
     */
    User getUserDetails(String token);

    /**
     * Find user in db by email and password
     * @param email
     * @param password
     * @return
     */
    User getUserDetails(String email, String password);

    /**
     * Find and update user detail
     * @param user
     */
    void updateUserDetails(User user);

}
