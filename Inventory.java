import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Inventory {

    public static void main(String[] args) {

        // arraylists for each column
        ArrayList<Integer> productIDs = new ArrayList<>();
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> warehouseQty = new ArrayList<>();
        ArrayList<Integer> storeQty = new ArrayList<>();

        // warehouse data
        String[] warehouseData = {
                "2001,USB-C Cable,123",
                "2002,Wireless Mouse,85",
                "2003,Laptop Stand,60",
                "2004,Notebook,200",
                "2005,Pen Pack,180",
                "2006,Backpack,45",
                "2007,Water Bottle,75",
                "2008,Keyboard,90",
                "2009,HDMI Cable,110",
                "2010,Phone Charger,95",
                "2011,Desk Lamp,40",
                "2012,Calculator,55",
                "2013,Sticky Notes,300",
                "2014,Monitor Stand,50",
                "2015,Webcam,65",
                "2016,Headphones,70",
                "2017,Mouse Pad,140",
                "2018,Planner,160",
                "2019,Flash Drive,130",
                "2020,Whiteboard Marker,210"
        };

        // store data
        String[] storeData = {
                "2001,118", "2002,85", "2003,62", "2004,198", "2005,180",
                "2006,40", "2007,75", "2008,92", "2009,110", "2010,90",
                "2011,38", "2012,55", "2013,295", "2014,48", "2015,70",
                "2016,68", "2017,140", "2018,155", "2019,130", "2020,205"
        };

        // read warehouse data and split it into the arraylists
        for (int i = 0; i < warehouseData.length; i++) {
            String[] parts = warehouseData[i].split(",");
            productIDs.add(Integer.parseInt(parts[0]));
            productNames.add(parts[1]);
            warehouseQty.add(Integer.parseInt(parts[2]));
        }

        // fill storeQty with 0s first
        for (int i = 0; i < productIDs.size(); i++) {
            storeQty.add(0);
        }

        // go through store data and match quantities by product id
        for (int i = 0; i < storeData.length; i++) {
            String[] parts = storeData[i].split(",");
            int id = Integer.parseInt(parts[0]);
            int qty = Integer.parseInt(parts[1]);

            // find where this id is in the productIDs list
            for (int j = 0; j < productIDs.size(); j++) {
                if (productIDs.get(j) == id) {
                    storeQty.set(j, qty);
                    break;
                }
            }
        }

        // count totals and find mismatches
        int totalWarehouse = 0;
        int totalStore = 0;
        int mismatchCount = 0;
        ArrayList<Integer> mismatchIndices = new ArrayList<>();

        for (int i = 0; i < productIDs.size(); i++) {
            totalWarehouse += warehouseQty.get(i);
            totalStore += storeQty.get(i);

            if (!warehouseQty.get(i).equals(storeQty.get(i))) {
                mismatchCount++;
                mismatchIndices.add(i);
            }
        }

        // sort mismatches by biggest difference using selection sort
        for (int i = 0; i < mismatchIndices.size() - 1; i++) {
            for (int j = i + 1; j < mismatchIndices.size(); j++) {
                int diff1 = Math.abs(warehouseQty.get(mismatchIndices.get(i)) - storeQty.get(mismatchIndices.get(i)));
                int diff2 = Math.abs(warehouseQty.get(mismatchIndices.get(j)) - storeQty.get(mismatchIndices.get(j)));
                if (diff2 > diff1) {
                    int temp = mismatchIndices.get(i);
                    mismatchIndices.set(i, mismatchIndices.get(j));
                    mismatchIndices.set(j, temp);
                }
            }
        }

        // print the report with date/time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
        System.out.println("Report Generated: " + now.format(formatter));
        System.out.println();

        System.out.println("INVENTORY RECONCILIATION REPORT");
        System.out.println("----------------------------------");
        System.out.println("Total Warehouse Inventory: " + totalWarehouse);
        System.out.println("Total Store Inventory: " + totalStore);
        System.out.println("Mismatched Products: " + mismatchCount);
        System.out.println();

        // print discrepancy report
        System.out.println("DISCREPANCY REPORT (Sorted by Largest Difference)");
        System.out.println("ID     Product              Warehouse  Store  Difference");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < mismatchIndices.size(); i++) {
            int idx = mismatchIndices.get(i);
            int diff = Math.abs(warehouseQty.get(idx) - storeQty.get(idx));

            // pad the product name so columns line up
            String name = productNames.get(idx);
            while (name.length() < 20) {
                name += " ";
            }

            System.out.println(productIDs.get(idx) + "   " + name + " "
                    + warehouseQty.get(idx) + "        "
                    + storeQty.get(idx) + "     " + diff);
        }
    }
}
