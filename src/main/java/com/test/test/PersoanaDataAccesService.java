package com.test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersoanaDataAccesService implements  PersoanaDo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersoanaDataAccesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insereazaPersoana(UUID id, Persoana persoana) {
        return 0;
    }

    @Override
    public List<Persoana> SelecteazaToatepersoanele() {
        final String sql ="SELECT id,name FROM person";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID id   = UUID.fromString(resultSet.getString("id"));
            String nume  =   resultSet.getString("name");
            String parola = resultSet.getString("parola");
            String email = resultSet.getString("email");
            String  numartelefon = resultSet.getString("numartelefon");
            return new  Persoana(id,nume,parola,email,numartelefon);
        });
    }

    @Override
    public Optional<Persoana> SelecteazapersoanaprinID(UUID id) {
        final String sql ="SELECT id,name FROM person  WHERE id =?";
        Persoana persoana = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID persoanaId   = UUID.fromString(resultSet.getString("id"));
                    String nume  =   resultSet.getString("name");
                    String parola = resultSet.getString("parola");
                    String email  = resultSet.getString("email");
                    String numartelefon = resultSet.getString("numartelefon");
                    return new  Persoana(persoanaId,nume,parola,email,numartelefon);
                });
        return  Optional.ofNullable(persoana);
    }

    @Override
    public int StergepersoanaprinID(UUID id) {
        return 0;
    }

    @Override
    public int ActualizarepersoanaprinID(UUID id, Persoana persoana) {
        return 0;
    }
}
