package com.entity;

import com.service.HumanService;
import junit.framework.TestCase;
import org.apache.log4j.Logger;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private static final Logger logger = Logger.getLogger(AppTest.class);

    private HumanService humanService = new HumanService();

    public void testApp() {
        humanService.beginTransaction();

        City cityPerm = humanService.addCity("Пермь");
        City cityMoscow = humanService.addCity("Москва");
        City citySamara = humanService.addCity("Самара");
        City cityEkb = humanService.addCity("Екатеринбург");
        City cityNn = humanService.addCity("Нижний Новгород");

        Human human = humanService.addHuman("Иван", "Петрович", "Васильев", cityPerm);
        Human human1 = humanService.addHuman("Андрей", "Алексеевич", "Сидоров", cityNn);
        Human human2 = humanService.addHuman("Роман", "Александрович", "Никулин", cityMoscow);
        Human human3 = humanService.addHuman("Борис", "Миронович", "Григорьев", cityEkb);
        Human human4 = humanService.addHuman("Валерий", "Наумович", "Богданов", cityMoscow);
        Human human5 = humanService.addHuman("Георгий", "Оскарович", "Егоров", cityPerm);
        Human human6 = humanService.addHuman("Денис", "Петрович", "Тимофеев", cityPerm);
        Human human7 = humanService.addHuman("Елисей", "Святославович", "Филиппов", cityPerm);
        Human human8 = humanService.addHuman("Зигфрид", "Филиппович", "Козлов", citySamara);
        Human human9 = humanService.addHuman("Максим", "Яковлевич", "Сорокин", citySamara);

        humanService.addAutoToHuman("Volkswagen", "Golf-6", human);
        humanService.addAutoToHuman("Lada", "Vesta", human);
        humanService.addAutoToHuman("Lada", "Niva", human1);
        humanService.addAutoToHuman("Lada", "Priora", human1);
        humanService.addAutoToHuman("Kia", "Sorento", human2);
        humanService.addAutoToHuman("Kia", "Rio", human3);
        humanService.addAutoToHuman("Toyta", "Rav4", human4);
        humanService.addAutoToHuman("Toyta", "Prius", human5);
        humanService.addAutoToHuman("Toyta", "Land Cruiser", human6);
        humanService.addAutoToHuman("Toyta", "Tundra", human7);
        humanService.addAutoToHuman("Kia", "Cerato", human8);
        humanService.addAutoToHuman("Renualt", "Coleos", human9);

        humanService.endTransaction();
    }
}
