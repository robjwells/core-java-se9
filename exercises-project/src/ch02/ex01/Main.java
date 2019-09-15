package ch02.ex01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

class Main {
    static final DayOfWeek DEFAULT_START_OF_WEEK = DayOfWeek.MONDAY;

    public static void main(String[] args) {
        switch (args.length) {
            case 0:
                printCalendar();
                break;
            case 1:
                printCalendar(Month.of(Integer.parseInt(args[0])));
                break;
            case 2:
                printCalendar(
                    Month.of(Integer.parseInt(args[0])),
                    Integer.parseInt(args[1])
                );
                break;
            default:
                break;
        }
    }

    public static void printCalendar() {
        printCalendar(DEFAULT_START_OF_WEEK);
    }

    public static void printCalendar(DayOfWeek weekStartDay) {
        printCalendar(weekStartDay, LocalDate.now().getMonth());
    }

    public static void printCalendar(Month month) {
        printCalendar(DEFAULT_START_OF_WEEK, month);
    }

    public static void printCalendar(DayOfWeek weekStartDay, Month month) {
        printCalendar(weekStartDay, month, LocalDate.now().getYear());
    }

    public static void printCalendar(Month month, int year) {
        printCalendar(DEFAULT_START_OF_WEEK, month, year);
    }

    public static void printCalendar(DayOfWeek weekStartDay, Month month, int year) {
        LocalDate dateCursor = LocalDate.of(year, month, 1);

        String headerString = String.format(
            "%s %d",
            dateCursor.getMonth().getDisplayName(TextStyle.FULL, Locale.UK),
            dateCursor.getYear()
        );
        String padding = " ".repeat((27 - headerString.length()) / 2);
        System.out.printf("%s%s%s\n", padding, headerString, padding);

        for (long adjust = 0; adjust < 7; adjust++) {
            System.out.printf(
                "%s ",
                weekStartDay.plus(adjust).getDisplayName(TextStyle.SHORT, Locale.UK)
            );
        }

        int daysToBlankOut = Math.floorMod(7 - (weekStartDay.getValue() - dateCursor.getDayOfWeek().getValue()), 7);

        System.out.print( "\n" + "    ".repeat(daysToBlankOut));

        DayOfWeek weekEndDay = weekStartDay.plus(6);
        while (dateCursor.getMonth().equals(month)) {
            System.out.printf("%3d ", dateCursor.getDayOfMonth());
            if (dateCursor.getDayOfWeek().equals(weekEndDay)) {
                System.out.println();
            }
            dateCursor = dateCursor.plusDays(1);
        }
        if (!dateCursor.getDayOfWeek().equals(weekStartDay)) {
            System.out.println();
        }
    }
}
