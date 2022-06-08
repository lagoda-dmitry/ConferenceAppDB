

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


/**
 *
 * @author senhe
 */
import java.sql.SQLException;

// Операции с таблицами
public interface TableOperation {
    void createTable() throws SQLException; // создание таблицы
    void createForeignKeys() throws SQLException; // создание связей между таблицами
    void createExtraConstraints() throws SQLException; // создание дополнительных правил для значений полей таблиц
}
