package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameToEmboss {

    private final String name;
    private final boolean expected;

    public CheckNameToEmboss(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][] {
                {"", false}, //пустая строка
                {"ТШ", false}, //2 символа (значение около границы)
                {"Т Ш", true}, //3 символа (пограничное значение)
                {"Ти Ш", true}, //4 символа (значение около границы)
                {"Тимоти Шаламе", true}, //13 символов, количество пробелов - 1, отсутствуют пробелы в начале и в конце
                {"Тимоти Шаламеигалл", true}, //18 символов (значение около границы)
                {"Тимоти Шаламеигаллы", true}, //19 символов (пограничное значение)
                {"Тимоти Шаламеигаллын", false}, //20 символов (значение около границы)
                {"Тимоти", false}, //количество пробелов - 0
                {"Тимоти Шал Аме", false}, //количество пробелов - 2
                {" Тимоти", false}, //пробел в начале строки
                {"Тимоти ", false}, //пробел в конце строки
                {null, false}
        });
    }

    @Test
    public void checkNameToEmbossTest() {

        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();

        assertEquals(expected, actual);
    }
}
