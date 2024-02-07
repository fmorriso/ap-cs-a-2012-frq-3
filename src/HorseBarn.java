public class HorseBarn
{
    private Horse[] spaces;

    /** Constructor that takes the number of stalls
     * @param numStalls - the number of stalls in the barn
     */
    public HorseBarn(int numStalls)
    {
        spaces = new Horse[numStalls];
    }

    /** Returns the index of the space that contains the horse with the specified name.
     * * Precondition: No two horses in the barn have the same name.
     * @param name the name of the horse to find
     * @return the index of the space containing the horse with the specified name;
     * -1 if no horse with the specified name is in the barn.
     */
    public int findHorseSpace(String name)
    {
        for (int i = 0; i < spaces.length; i++)
        {
            if(spaces[i] != null && spaces[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Consolidates the barn by moving horses so that the horses are in adjacent
     * spaces, starting at index 0, with no empty space between any two horses.
     * Postcondition: The order of the horses is the same as before the
     * consolidation.
     */
    public void consolidate() {
        Horse[] temp = new Horse[spaces.length];
        int idx = 0;
        for(int i = 0; i < spaces.length; i++)
        {
            if(spaces[i] != null)
            {
                temp[idx] = spaces[i];
                idx++;
            }
        }
        spaces = temp;
    }

    public String toString()
    {
        String result = "";
        Horse h = null;
        for (int i = 0; i < spaces.length; i++) {
            h = spaces[i];
            result = result + "space " + i + " has ";
            if (h == null) result = result + " null \n";
            else result = result + h.toString() + "\n";
        }
        return result;
    }

    public static void main (String[] args)
    {
        HorseBarn barn = new HorseBarn(7);
        barn.spaces[0] = new Horse("Trigger", 1340);
        barn.spaces[2] = new Horse("Silver",1210);
        barn.spaces[3] = new Horse("Lady", 1575);
        barn.spaces[5] = new Horse("Patches", 1350);
        barn.spaces[6] = new Horse("Duke", 1410);

        // print out what is in the barn
        System.out.println(barn);

        // test
        System.out.println("Index of Trigger should be 0 and is " +
                barn.findHorseSpace("Trigger"));
        System.out.println("Index of Silver should be 2 and is " +
                barn.findHorseSpace("Silver"));
        System.out.println("Index of Coco should be -1 and is " +
                barn.findHorseSpace("Coco"));
    }
}
