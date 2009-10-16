import org.specs._
import org.mockito.Matchers._

object UserServiceSpecification extends Specification with TestingEnvironment {
  override val userService = new UserService

  "UserService" should {
    "authenticate" in {
      val stubUser = User("user", "password")
      userRepository.authenticate(stubUser) returns stubUser

      val user = userService.authenticate("user", "password")

      user mustEqual stubUser
    }
  }
}
