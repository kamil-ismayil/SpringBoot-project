package com.example.todo.dao;

import com.example.todo.entities.Login;
import com.example.todo.input_forms.LoginForm;

public interface LoginDAO {
    public Login login(LoginForm loginform);
}
