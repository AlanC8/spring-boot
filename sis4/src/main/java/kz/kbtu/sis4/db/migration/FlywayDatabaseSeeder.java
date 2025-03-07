package kz.kbtu.sis4.db.migration;

import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlywayDatabaseSeeder implements Callback {

    @Override
    public boolean supports(Event event, Context context) {
        return event.equals(Event.AFTER_MIGRATE);
    }

    @Override
    public void handle(Event event, Context context) {
        try (var statement = context.getConnection().createStatement()) {

            // Проверяем существование таблицы users
            var checkTableQuery = """
                SELECT EXISTS (
                    SELECT FROM information_schema.tables 
                    WHERE table_name = 'users'
                )
            """;

            statement.execute(checkTableQuery);
            ResultSet tableExistsResult = statement.getResultSet();
            tableExistsResult.next();

            if (!tableExistsResult.getBoolean(1)) {
                System.out.println("Таблица 'users' не найдена. Seeder не выполняется.");
                return;
            }

            // Проверяем наличие супер-админа
            var ADMIN_EMAIL = "superadmin@example.com";
            var checkQuery = "SELECT id FROM users WHERE email = '" + ADMIN_EMAIL + "'";

            statement.execute(checkQuery);
            ResultSet resultSet = statement.getResultSet();

            // Используем resultSet.next() вместо resultSet.last()
            if (resultSet.next()) {
                System.out.println("Админ уже есть, пропускаем вставку.");
                return;
            }

            // Вставляем супер-админа
            var sql = """
                INSERT INTO users (email, name) VALUES
                ('%s', 'Super Admin')
            """.formatted(ADMIN_EMAIL);

            statement.execute(sql);
            System.out.println("Добавлен супер-админ.");

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка в FlywayDatabaseSeeder", e);
        }
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return true;
    }

    @Override
    public String getCallbackName() {
        return FlywayDatabaseSeeder.class.getName();
    }
}