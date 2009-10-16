import org.specs.mock.Mockito

trait TestingEnvironment
  extends UserServiceComponent
  with UserRepositoryComponent
  with Mockito {

  val userRepository = mock[UserRepository]
  val userService = mock[UserService]
}
