case class User(username: String, password: String)

trait UserRepositoryComponent {
  val userRepository = new UserRepository

  class UserRepository {
    def authenticate(user: User) = {
      println("Authenticating user: " + user)
      user
    }

    def create(user: User) = {
      println("Creating user: " + user)
      user
    }

    def delete(user: User) = println("Deleting user: " + user)
  }
}

trait UserServiceComponent {
  this: UserRepositoryComponent =>

  val userService = new UserService

  class UserService {
    def authenticate(username: String, password: String) =
      userRepository.authenticate(User(username, password))

    def create(username: String, password: String) =
      userRepository.create(User(username, password))

    def delete(user: User) = userRepository.delete(user)
  }
}

object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent {
  def main(args: Array[String]) {
    val user = userService.create("create", "password")
    val authenticatedUser = userService.authenticate("authenticate", "password")
    println("done")
  }
}

