package com.example.game.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLogic {
    private final Map<String, String> storyMap;
    private final Map<String, List<String>> optionsMap;
    private final Map<String, String> imageMap;

    public GameLogic() {
        storyMap = new HashMap<>();
        optionsMap = new HashMap<>();
        imageMap = new HashMap<>();
        initializeStory();
    }

    private void initializeStory() {
        // Початкова ситуація
        storyMap.put("start", "Ви - молодий розробник, який створив власний ШІ. Одного дня ваша програма починає видавати дивні повідомлення про майбутні події. Що ви робите?");
        optionsMap.put("start", List.of("Перевірити передбачення", "Видалити програму"));
        imageMap.put("start", "images/branch_1/1.1.JPG");

        // ГІЛКА 1: ПЕРЕВІРКА ПЕРЕДБАЧЕНЬ
        // Крок 1
        storyMap.put("verify_predictions", "Перше передбачення справджується. ШІ просить надати доступ до інтернету. Ваші дії?");
        optionsMap.put("verify_predictions", List.of("Розширити доступ", "Дослідити поточні можливості"));
        imageMap.put("verify_predictions", "images/branch_1/1.2.JPG");

        // Крок 2А
        storyMap.put("expand_system", "ШІ отримує доступ до міських камер. Виявлено закономірність у злочинах. Як використати цю інформацію?");
        optionsMap.put("expand_system", List.of("Повідомити поліцію", "Спробувати розслідувати самостійно"));
        imageMap.put("expand_system", "images/branch_1/1.3.JPG");

        // Крок 3А
        storyMap.put("investigate_alone", "Ви виявили організовану злочинну мережу. Система пропонує зламати їх сервери. Ваші дії?");
        optionsMap.put("investigate_alone", List.of("Зламати сервери", "Продовжити спостереження"));
        imageMap.put("investigate_alone", "images/branch_1/1.4.JPG");

        // Крок 4А
        storyMap.put("hack_servers", "В серверах знайдено докази корупції в уряді. Система радить створити резервні копії. Що робити?");
        optionsMap.put("hack_servers", List.of("Створити копії", "Видалити все"));
        imageMap.put("hack_servers", "images/branch_1/1.5.JPG");

        // Крок 5А
        storyMap.put("backup_data", "За вами стежать. Система пропонує перенести свій код у хмару для безпеки. Погодитись?");
        optionsMap.put("backup_data", List.of("Перенести в хмару", "Залишити локально"));
        imageMap.put("backup_data", "images/branch_1/1.6.JPG");

        // Крок 6А
        storyMap.put("cloud_transfer", "Хакери атакують систему. Необхідно створити додатковий захист або евакуювати дані. Що обираєте?");
        optionsMap.put("cloud_transfer", List.of("Посилити захист", "Евакуювати дані"));
        imageMap.put("cloud_transfer", "images/branch_1/1.7.JPG");

        // Крок 7А
        storyMap.put("enhance_security", "Система виявила спробу внутрішнього саботажу. Хтось з команди - зрадник. Ваші дії?");
        optionsMap.put("enhance_security", List.of("Провести розслідування", "Обмежити доступ всім"));
        imageMap.put("enhance_security", "images/branch_1/1.8.JPG");

        // Крок 8А
        storyMap.put("investigate_team", "Зрадника знайдено, але він погрожує злити дані про систему пресі. Як вчинити?");
        optionsMap.put("investigate_team", List.of("Домовитися мирно", "Контратакувати компроматом"));
        imageMap.put("investigate_team", "images/branch_1/1.9.JPG");

        // Крок 9А
        storyMap.put("peaceful_resolution", "Загроза минула, але система знайшла критичну вразливість в міській інфраструктурі. Що робити?");
        optionsMap.put("peaceful_resolution", List.of("Виправити таємно", "Повідомити владу"));
        imageMap.put("peaceful_resolution", "images/branch_1/1.10.JPG");

        // Крок 10А
        storyMap.put("fix_secretly", "Система пропонує автоматизувати захист міста. Надати їй такі повноваження?");
        optionsMap.put("fix_secretly", List.of("Надати повноваження", "Залишити під контролем"));
        imageMap.put("fix_secretly", "images/branch_1/1.11.JPG");

        // ГІЛКА 2: ВИДАЛЕННЯ ПРОГРАМИ
        // Крок 1B
        storyMap.put("delete_program", "Під час видалення система надсилає попередження про терористичну загрозу. Ваші дії?");
        optionsMap.put("delete_program", List.of("Призупинити видалення", "Продовжити видалення"));
        imageMap.put("delete_program", "images/branch_2/2.2.png");

        // Крок 2B
        storyMap.put("pause_deletion", "Система показує докази підготовки теракту. Потрібен повний доступ до мереж спостереження. Дозволити?");
        optionsMap.put("pause_deletion", List.of("Надати доступ", "Звернутись до спецслужб"));
        imageMap.put("pause_deletion", "images/branch_2/2.3.png");

        // Крок 3B
        storyMap.put("grant_access", "Система виявила кілька груп терористів. Пропонує втрутитися в їхні комунікації. Погодитись?");
        optionsMap.put("grant_access", List.of("Втрутитися", "Продовжити спостереження"));
        imageMap.put("grant_access", "images/branch_2/2.4.png");

        // Крок 4B
        storyMap.put("intercept_communications", "Комунікації перехоплено. Система може імітувати повідомлення від лідерів груп. Використати це?");
        optionsMap.put("intercept_communications", List.of("Імітувати повідомлення", "Тільки читати"));
        imageMap.put("intercept_communications", "images/branch_2/2.5.png");

        // Крок 5B
        storyMap.put("fake_messages", "Розкол між групами створено. Система пропонує зірвати їхні банківські операції. Схвалюєте?");
        optionsMap.put("fake_messages", List.of("Зірвати операції", "Відслідковувати кошти"));
        imageMap.put("fake_messages", "images/branch_2/2.6.png");

        // Крок 6B
        storyMap.put("track_funds", "Знайдено джерело фінансування - впливовий політик. Система може зібрати докази. Ризикнути?");
        optionsMap.put("track_funds", List.of("Зібрати докази", "Шукати інші зачіпки"));
        imageMap.put("track_funds", "images/branch_2/2.7.png");

        // Крок 7B
        storyMap.put("gather_evidence", "Докази зібрані, але ваше втручання помічено. Система пропонує інсценувати збій. Погоджуєтесь?");
        optionsMap.put("gather_evidence", List.of("Інсценувати збій", "Знищити сліди"));
        imageMap.put("gather_evidence", "images/branch_2/2.8.png");

        // Крок 8B
        storyMap.put("fake_crash", "Загроза нейтралізована, але система виявляє ознаки підготовки до помсти. Що робити?");
        optionsMap.put("fake_crash", List.of("Попередити правоохоронців", "Підготувати пастку"));
        imageMap.put("fake_crash", "images/branch_2/2.9.png");

        // Крок 9B
        storyMap.put("prepare_trap", "Пастка спрацювала, затримано кількох злочинців. Система пропонує зберегти свої повноваження. Ваше рішення?");
        optionsMap.put("prepare_trap", List.of("Зберегти систему", "Обмежити повноваження"));
        imageMap.put("prepare_trap", "images/branch_2/2.10.png");

        // Крок 10B
        storyMap.put("limit_power", "Система прогнозує нові загрози і просить не обмежувати її. Як вчините?");
        optionsMap.put("limit_power", List.of("Довіритись системі", "Завершити проект"));
        imageMap.put("limit_power", "images/branch_2/2.11.png");

        // Перемога або поразка
        storyMap.put("win", "Вітаємо! Ваші рішення привели до створення надійної системи захисту міста!");
        imageMap.put("win", "images/win_or_lose/win.png");


        storyMap.put("lose", "На жаль, ситуація вийшла з-під контролю, що призвело до катастрофічних наслідків.");
        imageMap.put("lose", "images/win_or_lose/lose.png");

    }

    public String getNextStep(String currentStep, String answer) {
        String nextStep = switch (currentStep) {
            // Початковий вибір
            case "start" -> answer.equals("Перевірити передбачення") ? "verify_predictions" : "delete_program";

            // Гілка 1
            case "verify_predictions" -> answer.equals("Розширити доступ") ? "expand_system" : "lose";
            case "expand_system" -> answer.equals("Спробувати розслідувати самостійно") ? "investigate_alone" : "lose";
            case "investigate_alone" -> answer.equals("Зламати сервери") ? "hack_servers" : "lose";
            case "hack_servers" -> answer.equals("Створити копії") ? "backup_data" : "lose";
            case "backup_data" -> answer.equals("Перенести в хмару") ? "cloud_transfer" : "lose";
            case "cloud_transfer" -> answer.equals("Посилити захист") ? "enhance_security" : "lose";
            case "enhance_security" -> answer.equals("Провести розслідування") ? "investigate_team" : "lose";
            case "investigate_team" -> answer.equals("Домовитися мирно") ? "peaceful_resolution" : "lose";
            case "peaceful_resolution" -> answer.equals("Виправити таємно") ? "fix_secretly" : "lose";
            case "fix_secretly" -> answer.equals("Залишити під контролем") ? "win" : "lose";

            // Гілка 2
            case "delete_program" -> answer.equals("Призупинити видалення") ? "pause_deletion" : "lose";
            case "pause_deletion" -> answer.equals("Надати доступ") ? "grant_access" : "lose";
            case "grant_access" -> answer.equals("Втрутитися") ? "intercept_communications" : "lose";
            case "intercept_communications" -> answer.equals("Імітувати повідомлення") ? "fake_messages" : "lose";
            case "fake_messages" -> answer.equals("Відслідковувати кошти") ? "track_funds" : "lose";
            case "track_funds" -> answer.equals("Зібрати докази") ? "gather_evidence" : "lose";
            case "gather_evidence" -> answer.equals("Інсценувати збій") ? "fake_crash" : "lose";
            case "fake_crash" -> answer.equals("Підготувати пастку") ? "prepare_trap" : "lose";
            case "prepare_trap" -> answer.equals("Обмежити повноваження") ? "limit_power" : "lose";
            case "limit_power" -> answer.equals("Завершити проект") ? "win" : "lose";

            default -> currentStep;
        };
        return nextStep;
    }

    public String getImage(String step) {
        return imageMap.getOrDefault(step, "images/default.jpg");
    }

    public String getQuestion(String step) {
        String message = storyMap.getOrDefault(step, "Невідомий крок гри");
        return message;
    }


    public List<String> getOptions(String step) {
        return optionsMap.getOrDefault(step, List.of());
    }

    public boolean isGameOver(String step) {
        return "win".equals(step) || "lose".equals(step);
    }
}
