# basicShellWithSpring
demo for using shell in Spring boot project

# unit tests are not attached hence build skipping the testing to prevent crash loop
Jivrajs-Air:one jivrajshekhawat$ ./mvnw clean install -DskipTests    

# run main application to use shell
Jivrajs-Air:one jivrajshekhawat$ java -jar target/one-0.0.1-SNAPSHOT.jar

# once deployed, available commands can be checked using commang 
shell:>help 

AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

# My Commands
        create_parking_lot: Create Parking lot
        leave:  leave parking facility
        park: Park Vehicle in next available parking
        registration_numbers_for_cars_with_colour: list all registration numbers of cars with given color
        slot_number_for_registration_number: list slot number of car with given registration number
        slot_numbers_for_cars_with_colour: list parking slots of cars with given color
        status: list all Parked vehicles
        
        

