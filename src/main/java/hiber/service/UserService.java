
package hiber.service;

        import hiber.model.User;

        import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void deleteAllUsers();
    User getUserByModelAndSeries(String car_model, String car_series);
}