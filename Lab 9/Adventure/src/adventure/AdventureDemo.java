package adventure;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.yaml.snakeyaml.Yaml;

/**
 * This class demonstrates how to read a YAML file using the SnakeYAML library
 * and process the resulting objects. It also demonstrates the use of the
 * Command class.
 *
 * <p>
 * Copyright 2017 Brent Yorgey. This work is licensed under a
 * <a rel="license" href= "http://creativecommons.org/licenses/by/4.0/">Creative
 * Commons Attribution 4.0 International License</a>.
 * </p>
 *
 * @author Brent Yorgey
 * @version August 21, 2017
 *
 */

public class AdventureDemo {

	private static List <Map<String, Object>> visited_list = new ArrayList<Map<String, Object>>();

	public static void main(String[] args) {

		// If anything goes wrong inside the 'try' (e.g. the file is not found),
		// it will jump to the 'catch' part.
		try {

			InputStream input = new FileInputStream(new File("Hendrix.yml"));

			// Create a Yaml object to parse the .yaml file
			Yaml yaml = new Yaml();

			Map<String, Object> places = new HashMap<String, Object>();

			Map<String, Object> here = null;

			List<Map<String, Object>> inventory = new ArrayList<Map<String, Object>>();

			int score = 0;

			int weight_limit = 4;

			int inv_weight = 0;

			boolean first = true;

			// Parse the .yaml file and loop over the resulting objects.
			for (Object thing : yaml.loadAll(input)) {

				Map<String, Object> location = (Map<String, Object>) thing;
				places.put((String)location.get("id"), location);

				if (first) {
					here = location;
					first = false;
				}
				// We happen to know that the YAML file contains key-value
				// mappings, so the returned Objects will in fact be Maps, and
				// we can cast them as such. Eclipse shows us a warning here
				// (yellow underline) because this code might crash if we call
				// it on the wrong sort of .yaml file and 'thing' is not
				// actually a Map.
			}


			printItems(here);

			Scanner in = new Scanner(System.in);
			Command com;

			do {
				System.out.print("? ");

				// Read the user's input and parse it using a Command object.
				com = new Command(in.nextLine());

				// Now we can query the Command object to find out what the user
				// typed. This example only pays attention to the verb (the
				// first word typed).
				if (com.getVerb().equals(Verb.UNKNOWN)) { System.out.println("What?"); }
				else {
					System.out.println("OK, you want to " + com.getVerb() + ".");

					if(com.getVerb() == Verb.GO){

						Map<String, Object> exits = (Map<String, Object>)here.get("exits");

						String newID = (String)exits.get(com.getDirection().toString().toLowerCase());

						if (newID != null){
							if (places.containsKey(newID)){

								here = (Map<String, Object>)places.get(newID);
								printItems(here);

							} else { System.out.println("That location looks shady, you avoid it."); }

						} else { System.out.println("You cannot go that way."); }

					} else if (com.getVerb() == Verb.TAKE) {

						List<Map<String, Object>> itemList = (List<Map<String, Object>>) here.get("items");

						Map<String, Object> item = findItem(itemList, com.getNoun());

						Boolean portable = (Boolean) item.get("portable");

						if (item != null && portable == null && (inv_weight + (int)item.get("weight") < weight_limit) ) {
							itemList.remove(item);
							inventory.add(item);
							inv_weight += (int)item.get("weight");
							System.out.println("Taken");
						} else if(portable == false) { System.out.println("The " + com.getNoun() + " is not portable."); }

						else if ((inv_weight + (int)item.get("weight") > weight_limit)) {System.out.println("You are already carrying too much."); }

						else { System.out.println("There is no " + com.getNoun() + " here."); }

					} else if (com.getVerb() == Verb. INVENTORY) {
						if (inventory.size() > 0) {
							for (Map<String, Object> itemAttributes : inventory) {
								System.out.println(itemAttributes.get("name"));
								System.out.println("Weight: " + itemAttributes.get("weight"));
							}
						} else { System.out.println("You have nothing in your inventory."); }

					} else if (com.getVerb() == Verb.DROP) {
						Map<String, Object> item = findItem(inventory, com.getNoun());
						if(item != null){
							inventory.remove(item);
							List<Map<String, Object>> itemList = (List<Map<String, Object>>) here.get("items");

							if (item.containsKey("goal") && here.get("id").equals(item.get("goal"))) {
								score += (int)item.get("score");
								System.out.println(item.get("goalmessage"));
							}

							if(itemList == null) {
								itemList = new ArrayList<Map<String, Object>>();
								here.put("items", itemList);
							}

						} else { System.out.println("You do not have a " + com.getNoun()); }

					} else if (com.getVerb() == Verb.SCORE) { System.out.println("Your score is " + score); }

					else if (com.getVerb() == Verb.LOOK) {
						if (!com.getNoun().equals("")) {
							List<Map<String, Object>> itemList = (List<Map<String, Object>>) here.get("items");
							Map<String, Object> hereItem = findItem(itemList, com.getNoun());
							Map<String, Object> Item = findItem(inventory, com.getNoun());
							if (hereItem != null) { System.out.println(hereItem.get("desc")); }

							if (Item != null) { System.out.println(Item.get("desc")); }

							if (hereItem == null && Item == null) { System.out.println("I don't see one of those here."); }

						} else if (com.getNoun().equals("") && !com.getDirection().equals(Direction.UNKNOWN)) {
							Map<String, String> theseExits = (Map<String, String>) here.get("exits");
							if (theseExits.containsKey(com.getDirection().toString().toLowerCase())) {
								Map<String, Object> placename = (Map<String, Object>) places.get(theseExits.get(com.getDirection().toString().toLowerCase()));
								if (placename.containsKey("article")) {
									System.out.println("You can see " + placename.get("article") + " " + placename.get("name") + " in that direction.");
								} else if (!placename.containsKey("article")){
									System.out.println("You can see " + placename.get("name") + " in that direction.");
								} else {
									System.out.println("There's nothing to see that way");
								}
								System.out.println(placename.get("name"));
							}
						} else if (com.getNoun().equals("") && com.getDirection().equals(Direction.UNKNOWN)) { System.out.println(here.get("longdesc")); }
					}
					else if (com.getVerb() == Verb.HELP){
						System.out.println("Explore your surroundings.  You can get points by taking certain\n" +
								"      objects to certain other locations.\n" +
								"\n" +
								"    Available commands:\n" +
								"      go <dir>        - move in a certain direction\n" +
								"      look            - look at your surroundings\n" +
								"      look <dir>      - see what location lies in a given direction\n" +
								"      look [at] <obj> - look at an object in your location or inventory\n" +
								"      take <obj>      - pick up an object\n" +
								"      drop <obj>      - put down an object\n" +
								"      inventory       - see what you are carrying\n" +
								"      score           - see your current score\n" +
								"      help            - show this help message\n" +
								"      quit            - quit\n" +
								"\n" +
								"    Available directions:\n" +
								"      north south east west northeast northwest southeast southwest up down in out ");
					}
				}
			} while (com.getVerb() != Verb.QUIT);

			in.close();



		} catch (IOException e) {
			// This is what to do if anything goes wrong, e.g. the file
			// Hendrix.yaml is not found. Just print the error and quit.
			System.out.println(e);
			System.exit(1);
		}
	}

	private static Map<String, Object> findItem(List<Map<String, Object>> itemList, String what) {
		if (itemList != null) {
			for (Map<String, Object> itemAttributes : itemList) {
				if (((String) itemAttributes.get("name")).toLowerCase().equals(what.toLowerCase())) {
					return itemAttributes;
				} else if (itemAttributes.get("aliases") != null) {
					ArrayList<String> aliases_list = (ArrayList<String>) (itemAttributes.get("aliases"));
					for (int i = 0; i < aliases_list.size(); i++) {
						if (aliases_list.get(i).equals(what.toLowerCase())) {
							return itemAttributes;
						}

					}
				}
			}
		}
		return null;
	}

	/**
	 * Take a key-value mapping representing a location in the world. Look
	 * through it and print any items it contains.
	 *
	 * @param location
	 *            The key-value mapping representing the location.
	 */
	private static void printItems(Map<String, Object> location) {

		if( visited_list.contains(location) ) {
			System.out.println(location.get("desc"));

		} else {
			System.out.println(location.get("longdesc"));
			visited_list.add(location);
		}

		// Extract the list of items, which is stored under the key "items".
		// Each item is itself a key-value mapping.
		List<Map<String, Object>> itemList = (List<Map<String, Object>>) location.get("items");

		// If the location does not have a key called "items", then the call to
		// get("items") above will return null.
		if (itemList != null) {

			// For each item, get the values associated to the keys "name" and
			// "portable".
			for (Map<String, Object> itemAttributes : itemList) {
				if (itemAttributes.get("portable") == null){
					System.out.print("  " + itemAttributes.get("name"));
				}

				// Cast the "portable" value to a Boolean (not boolean) since
				// Boolean is an object type and can be null. If there is no
				// "portable" key then the result will be null and we can check
				// for that case. If we had used boolean instead, it would crash
				// when the key "portable" does not exist.
				//Boolean portable = (Boolean) itemAttributes.get("portable");

				// Items are portable by default.  They are non-portable only
				// if the "portable" key exists and has the value false.
				//if (portable != null && !portable) { System.out.println(" (non-portable)"); }
			}
			System.out.println();
		}
	}
}