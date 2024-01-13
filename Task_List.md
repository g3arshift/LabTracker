## General Idea
* An application that allows you to track the inventory of a homelab. This includes both physical inventory, and digital for things like VM's.
* Key features: FLEXIBLE, BUT ALSO EASY TO USE AND DEPLOY. GOAL IS TO BE ABLE TO EXPAND TO MOBILE APP, BUT ALSO JUST SIMPLY RUN AND DEPLOY AS STANDALONE OR IN DOCKER/PODMAN. MOBILE APP TARGET IS LATER. JUST LEAVE FRAMEWORK EXPANDABLE. Set it up so multi-user 
	* Allows you to create whitebox builds using inventory
	* If item added to whitebox is not in inventory, allow in menu item creation
	* Allow user created object types
	* Note section for inventory items, but especially systems
	* Web application. The Java code runs as the backend with an embedded DB, and you access it through a browser. It also has an API for possible future mobile releases that simply contact back to a hosted app.
* Expected use case: Tracking items. By default setup for a single user, but more users can be added
	*Requires login, but not simultaneous session or multi-user tracking
* Misc Notes:
	* Inventory items have both a picture associated with them as an type of object and a specific object, as well as a gallery for the specific object
	* Read all object types from the DB, including default object types
		* Create super object type for the DB items so we can handle reading everything from DB
	* Use H2DB http://www.h2database.com/html/cheatSheet.html
* Scan the source code with a vulnerability chcker https://mergebase.com/blog/java-scanning/
* Salt and hash passwords in DB
* Create a graph to view and compare data on inventory items based on BuyPrice and SellPrice
* Add support for parsing PCPartPicker links into valid builds
* Use Hibernate
* App demo on website
* Installer and uninstaller

## Tasks

###Part 0: Setup and Planning

* [ ] Create database schema diagram
	* [ ] Create a database schema
	* [ ] Only do soft deletes. When a user deletes an item, mark it for deletion, which will then be properly deleted in 30 days. Perform this action when the application is booted.
	* Mark what user made the change to an item, and when
	* Mark which user created an item, and when
	* [ ] Populate a test database with test data
	* [ ] On Start have it prompt user for a username and password if it doesn't exist, then create the DB with those
	* [ ] Timestamp updating has to happen IN CODE. H2 doesn't support it
* [ ] Salt and hash password with bcrypt https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt



###Part 1: Backend Implementation
* [ ] Setup spring in main
* [ ] Database Backup
* [ ] Database Restore
* [ ] DB item undelete
* [ ] UpdateApplication (contacts the GH repo for an update script, then downloads it and follows it)
* [ ] Repositories
	* [ ] Create InventoryItem Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByName
		* [ ] findByItemType
		* [ ] findByStatus
	* [ ] Create SystemRepository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findBySystemType
		* [ ] findByWhiteboxStatus
	* [ ] Create UPS Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByNetworkedStatus
	* [ ] Create CPU Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByBrand
		* [ ] findByCoreCount
		* [ ] findByThreadCount
	* [ ] Create Motherboard Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByCPUBrand
		* [ ] findByChipset
	* [ ] Create RAM Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByGeneration
		* [ ] findByCapacity
		* [ ] findBySpeed
	* [ ] Create GPU Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByBrand
	* [ ] Create PSU Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByWattage
		* [ ] findByFormFactor
		* [ ] findByEfficiency
	* [ ] Create Storage Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByCapacity
		* [ ] findByInterfaceType
		* [ ] findByDriveType
	* [ ] Create Case Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByStyle
		* [ ] findBySize
	* [ ] Create Fan Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findBySize
		* [ ] findByThickness
		* [ ] findBySpeed
		* [ ] findByPressure
	* [ ] Create Cooler Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByType
	* [ ] Create Pump Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByType
	* [ ] Create Fitting Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findBySize
	* [ ] Create Tubing Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findBySize
	* [ ] Create Radiator Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByNumFans
		* [ ] findByFanSize
	* [ ] Create Waterblock Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findBySocket
	* [ ] Create PCIeCard Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findBySlotType
	* [ ] Create StorageAdapters Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByNumPorts
		* [ ] findByInterfaceType
		* [ ] findByCardType
	* [ ] Create NetworkCards Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByNumPorts
		* [ ] findByPortSpeed
		* [ ] findByPortType
	* [ ] Create Rack Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByRackSize
		* [ ] findByPostStyle
	* [ ] Create NetworkingGear Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
		* [ ] findByType
	* [ ] Create VirtualSystem Repository
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findById
		* [ ] findAll
	* [ ] Create UserRepository
		* [ ] add
		* [ ] delete (when deleting a user, prompt the person deleting if they want to transfer all the DB items the user they are deleting owns to them. Otherwise, delete those items)
		* [ ] update
		* [ ] findAll
		* [ ] findByUsername
		* [ ] findByGroup
* [ ] Services
	* [ ] Validation
	* [ ] GraphService (for creating graphs based on purchase history and dates)
	* [ ] InventoryItemService
		* [ ] add
		* [ ] delete
		* [ ] update
		* [ ] findAll
		* [ ] updateBaseImage
		* [ ] addImageToGallery (gallery final name extensions are _currentTimestamp)
	* [ ] UserService
* [ ] Controllers
* [ ] Security
* [ ] Models
	* [X] User
		* Username
		* Password
		* first name
		* last name
		* Group
	* [X] InventoryItem
		* id
		* Name
		* Picture (*THIS WILL BE STORED AS A FILE ON THE USERS SYSTEM)
		* Gallery (Supports AVIF, JPEG, PNG, and WebP)
		* location
		* BuyPrice
		* SellPrice
		* ItemURL (a link to where it was bought or can be purchased)
		* Notes
		* EditGroup (list of groups that can edit this item)
		* Status
		* UserItem
		* Owner
		* [X] Constructor
		* [X] Getters
		* [X] Setters
			* [ ] System
				* ComputerType
				* IPAddress
				* ManagementIPAddress (optional)
				* AdditionalIPAddresses (optional)
				* Gallery
				* CPU
				* CPUCount
				* Motherboard
				* PSU
				* RAM
				* OSDrive
				* Storage
				* Cooling
				* PCIe Cards
				* ExtraParts (This is the "location" variable in an inventory item)
				* VirtualSystems
				* isWhitebox
				* OS Name
				* [ ] Networking Gear
					* GearType
					* ManagementIPAddress
					* additional IP Addresses
					* Ports
				* [ ] VirtualSystem
					* Host ID
					* OS
					* IP Address
					* [ ] VM
						* RAM
						* core count
						* Storage ID
					* [ ] Container
						* Host Port
						* Container Port
		* [ ] UPS
			* WattCapacity
			* RackUnitSize
			* Voltage
			* Num Ports
			* port type
			* plug type
		* [ ] Components
			* [X] CPU
				* CPUBrand
				* BaseClock
				* BoostClock
				* CoreCount(p-cores if e-cores is filled out)
				* ThreadCount
				* ECoreCountPhysical
				* Cache
			* [ ] Motherboard
				* CPUBrand
				* Chipset
				* SocketCount
				* FormFactor
				* Socket
			* [X] RAM
				* Generation
				* Capacity
				* Speed
				* type (dimm vs sodimm, etc)
				* buffered
				* ecc
				* numsticks
			* [ ] PSU
				* Wattage
				* FormFactor
				* Efficiency
			* [X] Storage
				* Capacity
				* InterfaceType
				* [X] SSD
					* Endurance
					* Drive Writes Per Day
				* [X] HDD
					* Workload Limit Rating
					* Rotational speed
					* Cache
			* [X] SystemCase
				* CaseStyle
				* Size (optional, in rack units)
				* Num 3.5" Drive bays
				* Num 2.5" drive bays
				* isRackmount
			* [ ] Fans
				* Size
				* brand
				* Thickness (optional)
				* Speed
				* airflow (measured in CFM)
				* Static Pressure (measured in mm h20)
				* connector type (PWM, DC, ETC)
				* voltage
			* [ ] Cooler
				* CoolerType
				* Brand (custom if set to CustomLoop)
			* [ ] Watercooling Components
				* [ ] Pumps
					* PumpType
					* PowerType
					* Speed
				* [ ] Fittings
					* Size
					* Brand
				* [ ] Tubing
					* Size
					* Length
				* [ ] Radiator
					* NumFans
					* Brand
					* FanSize
					* FinDensity (fins per inch)
					* Thickness (measured in mm)
					* Material (copper, aluminum, etc)
				* [ ] Waterblocks
					* Socket
					* Coldplate Material
					* Block Material
			* [ ] PCIe Cards
				* PcieSlotType
				* NumCaseSlotsOccupied
					* [ ] StorageAdapters
						* NumPorts
						* InterfaceType
						* CardType
					* [ ] Network Cards
						* NumPorts
						* PortSpeed
						* PortType
					* [ ] GPU
						* GPUBrand
						* Core speed
						* Memory speed
						* VRAM
						* Length
						* height
		* [ ] Rack
			* RackSize (in rack units)
			* PostStyle
	* [ ] Result
		* messages (List<String>)
		* type (ResultType)
		* payload (generic)
		* [ ] isSuccess
		* [ ] addMessage
		* [ ] Getters
		* [ ] Setters
	* [ ] Error Response
		* buildResponse
		
		
		
####Enums
	* [X] ResultType
		* success, invalid, not_found
	* [X] PermissionLevel
		* Admin, User, View
		* Each permission level contains all other permissions below it.
			* Admin can load and backup DB, as well as delete and edit objects that don't belong to them
			* User can't backup or load DB, but can edit and delete objects that belong to them and view ALL objects
			* View can only view objects, but cannot modify the data in any way.
	* [ ] InventoryItemStatus - User can create new groups
		* Installed, In Storage, Purchased, Sold, To be purchased, Broken
	* [ ] CaseStyle - User can create new groups
		* Like Full tower, XL Tower, Mini tower, etc
	* [X] InterfaceType
		* U.2, M.2, SAS2, SAS3, SATA, PCIe
	* [X] PcieSlotType
		* x1, x4, x8, x16
	* [X] RAMGeneration
		* DDR2, DDR3, DDR4, DDR5
	* [X] CPUBrand
		* AMD, Intel
	* [X] GPUBrand
		* AMD, Intel, Nvidia
	* [ ] MotherboardFormFactor - User can create new groups
		* MiniITX, MicroATX, ATX, EATX, XLATX, SSICEB, SSIEEB, SSIMEB
	* [ ] PSUFormFactor - User can create new groups
		* ATX, TFX, SFX, SFX-L
	* [ ] FanSize - User can create new groups
		* 40, 60, 80, 92, 120, 140, 200
	* [ ] PumpType - User can create new groups
		* DDC, D5
	* [X] RackPostType
		* TwoPost, FourPost
	* [ ] SystemType - User can create new groups
		* Server, Desktop
	* [X] PSUEfficiencyType
		* Plus, Bronze, Silver, gold, Platinum, Titanium
	* [ ] CoolerType - User can create new groups
		* AirTower, AIO, CustomLoop, Immersion
	* [X] StorageCardType
		* HBA, RAID
	* [ ] NetworkPortType - User can create new groups
		* Ethernet, Fiber
	* [ ] NetworkGearType - User can create new groups
		* Switch, Router, Firewall



###Part 1.1: Backend Testing
* Create a random equipment generator for testing
* Test UserItems with a box of cable and a bag containing 3ft of fiber.
* [ ] Tests



###Part 2: Frontend
* [ ] Use React