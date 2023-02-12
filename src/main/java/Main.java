import features.dbQueryService.DatabaseQueryService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1. run DatabaseInitService
        //2. run DatabasePopulateService
        //3. run this class
        DatabaseQueryService queryService = new DatabaseQueryService();

        printList(queryService.find_longest_project(), "Find longest project");
        printList(queryService.find_max_projects_client(), "Find max projects client");
        printList(queryService.find_max_salary_worker(), "Find max salary worker");
        printList(queryService.find_youngest_eldest_workers(), "Find youngest eldest workers");
        printList(queryService.print_project_prices(), "Print project prices");

        System.gc();
    }

    private static <T> void printList(List<T> list, String topic) {
        System.out.println("--------------" + topic + "--------------");
        for (T object : list) {
            System.out.println(object);
        }
        System.out.println();
    }
}