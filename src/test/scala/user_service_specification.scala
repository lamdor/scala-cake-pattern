import org.specs._

object UserServiceSpecification extends Specification with TestingEnvironment {
  override val userService = new UserService

  "UserService" should {
    "authenticate" in {
      userRepository.authenticate(User("user", "password")) returns User("user", "password")

      val user = userService.authenticate("user", "password")

      user.username mustEqual "user"
      user.password mustEqual "password"
    }
  }
}
