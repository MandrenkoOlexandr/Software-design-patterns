package HMW_5.Task_2;

import java.util.ArrayList;
import java.util.List;

// Конкретний Будівельник
class MyStringBuilder implements IStringBuilder {
    private List<Character> characters = new ArrayList<>();

    @Override
    public IStringBuilder append(String str) {
        if (str != null) {
            for (char c : str.toCharArray()) {
                characters.add(c);
            }
        }
        return this; // Повертаємо self для ланцюжкових викликів (Fluent Interface)
    }

    @Override
    public IStringBuilder insert(int offset, String str) {
        if (str != null && offset >= 0 && offset <= characters.size()) {
            char[] insertChars = str.toCharArray();
            for (int i = 0; i < insertChars.length; i++) {
                // Вставляємо символи один за одним у вказану позицію
                characters.add(offset + i, insertChars[i]);
            }
        } else {
            throw new StringIndexOutOfBoundsException(offset);
        }
        return this;
    }

    @Override
    public CustomString build() {
        StringBuilder finalStr = new StringBuilder();
        for (Character c : characters) {
            finalStr.append(c);
        }
        return new CustomString(finalStr.toString());
    }
}
