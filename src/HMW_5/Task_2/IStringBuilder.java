package HMW_5.Task_2;

// Інтерфейс Будівельника
interface IStringBuilder {
    IStringBuilder append(String str);

    IStringBuilder insert(int offset, String str);

    CustomString build();
}
