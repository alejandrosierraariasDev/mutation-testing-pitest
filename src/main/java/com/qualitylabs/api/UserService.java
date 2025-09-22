package com.qualitylabs.api;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final int MIN_AGE = 18;

    /**
     * Valida si un usuario tiene la edad suficiente.
     * @param age La edad del usuario.
     * @return true si el usuario tiene la edad mínima o más, false en caso contrario.
     */
    public boolean isValidAge(int age) {
        // La condición de aquí tiene una mutación potencial.
        // ¿Qué pasa si el test no valida el caso de `age == MIN_AGE`?
        return age > MIN_AGE;
    }

    /**
     * Devuelve un mensaje de bienvenida.
     */
    public String getWelcomeMessage(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "¡Bienvenido, invitado!";
        }
        return "¡Bienvenido, " + name + "!";
    }
}