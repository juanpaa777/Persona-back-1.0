    package com.lksbass.modulos.regulatorios.service;


    import com.lksbass.modulos.regulatorios.model.Persona;
    import com.lksbass.modulos.regulatorios.repository.PersonaRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class PersonaService {
        @Autowired
        private PersonaRepository personaRepository;

        public List<Persona> findAll() {
            return personaRepository.findAll();
        }

        public Persona save(Persona persona) {
            return personaRepository.save(persona);
        }

        public Optional<Persona> findById(Long id) {
            return personaRepository.findById(id);
        }

        public boolean deleteById(Long id) {
            if (personaRepository.existsById(id)) {
                personaRepository.deleteById(id);
                return true;
            }
            return false;
        }
    }