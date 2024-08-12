public class Driver {
    public static void main(String[] args) {
        LewisStructureDLL example = new LewisStructureDLL('N');
        example.add('C', "East");
        example.add('A', "South");
        example.move("North");
        example.move("West");
        example.add('K', "South");
        example.add('M', "West");
        example.print();
    }
}
