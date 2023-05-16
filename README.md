## Read from TWO inputs files: phone book file and instruction file
When the ECB system starts up, it assumes that an electronic phone book has the contact
information as given in the phone book file, and it manages the contact records according to
the instructions in the instruction file.
•
•
Phone book file contains contact information in a predefined format;
Instruction file lists instructions/commands to be performed on the records. The
instructions/commands can be: “add”, “delete”, “query”, and “save”.

## Add a record (a person’s contact details) to your phone book o For instance, the instruction
add name Jo Bloggs; birthday 08-07-1980; phone 88884444; address 9001 Chester Crescent
is supposed to add/update a record for a person with name "Jo Bloggs", birthday 8/7/1980, phone
number 88884444 and address "9001 Chester Crescent".
Your ECB system checks whether this is an existing record:
•
•
if both person name and birthday are identical to those of an existing record in your phone book,
the existing record will be updated with the new input information. E.g., update the items of
address, email, and phone.
otherwise your system adds the new valid record to the list.


## Delete record(s) from your list by name
For instance, the instruction
delete Jeff Vader indicates deleting the record(s) with name “Jeff Vader” from the list.
delete Jeff Vader ; 8-07-1980 indicates deleting the record with name “Jeff Vader” and birthday
“08/07/1980” from the list.

## Query the records by person name, birthday, or phone number.
For instance,
query birthday 8-09-1991
query name David Joans o query phone 9110110
NOTE: If there are more than one query results, all the query results should be saved in ascending
order of person name and birthday.

## Save the resulting data collection to output file(s)
Save the resulting data collection of the instructions of “add” and “delete” into the specified output file
Save the query results to a separate specified report file. When there are more than one “query”
command, append the latest query results to the end of the report file. Separate the results of different
query instructions using dash lines with query instructions.
