# exercise-project-fairyShop-Java-OOP-
Exercies-Java-OOP course @ Software University
1.	Overview
Christmas is over, February 14th too, but the Tooth Fairy is always here. As you know, she can't do it alone, so she has helpers.
Your task is to create a Fairy Shop project, where different types of Helpers crafts Presents. Each helper has an energy level, which drops while working on a present, and Instruments that lose power, again while working on a present. 
2.	Task 1: Structure 
You are given interfaces, and you have to implement their functionality in the correct classes.
There are 4 types of entities in the application: Helper, Present, Shop, and Instrument. 
There should also have been a HelperRepository, as well as PresentRepository.
BaseHelper
BaseHelper is a base class or any type of Helper and it should not be able to be instantiated.
Data
•	name – String 
o	If the name is null or whitespace, throw a NullPointerException with a message: 
"Helper name cannot be null or empty."
o	All names will be unique.
•	energy –  int
o	The energy of a helper.
•	instruments – Collection<Instrument>
o	A collection of a helper's instruments.
Constructor
A BaseHelper should take the following values upon initialization: 
(String name, int energy)
Behavior
void work() 
The work() method decreases helpers' energy by 10. 
•	A helper's energy should not drop below 0 (If the power becomes less than 0, set it to 0).
void addInstrument(Instrument instrument)
This method adds an instrument to the helper's collection of instruments. 
boolean canWork()
This method returns:
•	true - if the current energy of the helper is greater than 0;
•	false - otherwise.
Child Classes
There are two types of BaseHelper:
Happy
Initial energy units: 100
The constructor should take the following values upon initialization:
(String name)
Sleepy
Initial energy units: 50
The method work() decreases the helpers' energy by additional 5 units.
The constructor should take the following values upon initialization:
(String name)
InstrumentImpl
The InstrumentImpl is a class that represents the tool, which a Helper uses to craft Present. 
It should be able to be instantiated.
Data
•	power – int
o	The power of an instrument.
o	If the initial power is below 0, throw an IllegalArgumentException with a message:
 "Cannot create an Instrument with negative power!".
Constructor
An InstrumentImpl should take the following values upon initialization: 
(int power)
Behavior
void use()
The use() method decreases the instrument's power by 10. 
•	An instrument's power should not drop below 0. (If the power becomes less than 0, set it to 0).
boolean isBroken()
This method returns true when power becomes equal to 0.	
PresentImpl
This is the class that holds information about the Present that a Helper is working on. 
It should be able to be instantiated.
Data
•	name - String 
o	If the name is null or whitespace, throw a NullPointerException with a message: 
"Present name cannot be null or empty.".
•	energyRequired – int 
o	The energy a present requires in order to be crafted.
o	If the initial energy is below 0, throw an IllegalArgumentException with a message:
 "Cannot create a Present requiring negative energy!".
Constructor
An PresentImpl should take the following values upon initialization: 
(String name, int energyRequired)
Behavior
void getCrafted()
The getCrafted() decreases the required energy of the present by 10 units.
•	A present's required energy should not drop below 0 (If the energy becomes less than 0, set it to 0).
boolean isDone()
The isDone() method returns true if the energyRequired reaches 0.
ShopImpl
Create a ShopImpl class. The ShopImpl class holds the main action, which is the craft method.
Behavior
void craft(Present present, Helper helper) 
Here is how the craft method works: 
•	The helper starts crafting the present. This is only possible if the helper has energy and an instrument that isn't broken.
•	Keep working until the present is done or the helper has energy (and instruments to use).
•	If at some point the power of the current instrument reaches or drops below 0, meaning it is broken, then the helper should take the next instrument from its collection, if it has any left.
HelperRepository
The helper repository is a repository for the helpers working at Fairy’s Shop.
Data
•	helpers – a collection of helpers
Behavior
void add(Helper helper)
•	Adds a helper to the collection.
•	Every helper is unique and it is guaranteed that there will not be a helper with the same name.
boolean remove(Helper helper)
•	Removes a helper from the collection.
•	Returns true if the deletion was successful.
Helper findByName(String name)
•	Returns a helper with that name if such exists.
Collection<Helper> getModels()
•	Returns a collection of helpers(unmodifiable).
PresentRepository
The present repository is a repository for presents that await to be crafted.
Data
•	presents – a collection of presents.
Behavior
void add(Present present)
•	Adds a present to be crafted.
•	Every present is unique and it is guaranteed that there will not be a present with the same name.
boolean remove(Present present)
•	Removes a present from the collection 
•	Returns true if the deletion was successful.
Present findByName(String name)
•	Returns a present with that name if such exists.
•	It is guaranteed that the present exists in the collection.
Collection<Present> getModels()
•	Returns collection of presents (unmodifiable).
Task 2: Business Logic 
The Controller Class
The business logic of the program should be concentrated around several commands. You are given interfaces, which you have to implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
The first interface is Controller. You must create a ControllerImpl class, which implements the interface and implements all its methods. The constructor of ControllerImpl does not take any arguments. The given methods should have the following logic:
Commands
There are several commands, which control the business logic of the application. They are stated below.
AddHelper Command
Parameters
•	type – String
•	helperName – String
Functionality
Creates a helper with the given name of the given type. 
If the helper is invalid, throw an IllegalArgumentException with a message:
"Helper type doesn't exist!"
The method should return the following message:
"Successfully added {helperType} named {helperName}!"
AddInstrumentToHelper Command
Parameters
•	helperName – String
•	power – int 
Functionality
Creates an instrument with the given power and adds it to the collection of the helper. 
If the helper doesn't exist, throw an IllegalArgumentException with a message:
"The helper you want to add an instrument to doesn't exist!"
The method should return the following message:
"Successfully added instrument with power {instrumentPower} to helper {helperName}!"
AddPresent Command
Parameters
•	presentName - String
•	energyRequired – int 
Functionality
Creates a present with the provided name and required energy and adds it to the corresponding repository.
The method should return the following message:
•	"Successfully added Present: {presentName}!"
CraftPresents Command
Parameters
•	presentName - String
Functionality
When the craft command is called, the action happens. 
You should start crafting the given present, by assigning helpers which are almost ready:
•	The helpers that you should select are the ones with energy above 50 units.
•	The selected helpers start working on the given present one by one until the present is crafted or no more helpers are available. If the present is crafted, you don't need to assign the remaining helpers.
•	If no helpers are ready, throw IllegalArgumentException with the following message: 
"There is no helper ready to start crafting!"
•	After the work is done, you must return the following message, reporting whether the present is done and how many total instruments were broken by the helpers who actually worked on the present:
"Present {presentName} is {done/not done}. {countBrokenInstruments} instrument/s have been broken while working on it!"
Note: The name of the present you receive will always be a valid one.
Report Command
Functionality
Returns information about crafted presents and helpers:
"{countCraftedPresents} presents are done!"
"Helpers info:"
"Name: {helperName1}"
"Energy: {helperEnergy1}"
"Instruments: {countInstruments} not broken left"
…
"Name: {helperNameN}"
"Energy: {helperEnergyN}"
"Instruments: {countInstruments} not broken left"
Exit Command
Ends the program.
Input / Output
You are provided with one interface, which will help you with the correct execution process of your program. The interface is Engine and the class implementing this interface should read the input and when the program finishes, this class should print the output.

