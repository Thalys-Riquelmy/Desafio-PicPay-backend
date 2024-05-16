package services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.user.User;
import domain.user.UserType;
import dtos.UserDTO;
import repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public void validateTransaction(User sender, BigDecimal anount)throws Exception {
		if(sender.getUserType() == UserType.MERCHANT) {
			throw new Exception("Usuário do tipo Logista não está autorizado a realizar transação");
		}
		if (sender.getBalance().compareTo(anount)<0) {
			throw new Exception("Saldo insuficiente");
		}
	}
	
	public User findUserById(Long id )throws Exception {
		return this.repository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
		}
	
	public List<User> getAllUsers(){
		return this.repository.findAll();
	}
	
	public User createUser(UserDTO data){
		User newUser = new User(data);
		this.saveUser(newUser);
		return newUser;
	}	
	public void saveUser(User user) {
		this.repository.save(user);
	}
}
