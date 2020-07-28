package com.datanauts.rest.dao;

import org.springframework.stereotype.Repository;

import com.datanauts.rest.model.User;
import com.datanauts.rest.model.Users;

@Repository
public class UserDAO 
{
    private static Users list = new Users();
    
    static 
    {
        list.getUserList().add(new User(1, "Stephen Brennan", "StephenBrenann@gmail.com", "5 St. Powers Walk Cresent","0851180846","0000001"));
        list.getUserList().add(new User(2, "Alex Smith", "AlexSmith@gmail.com", "5 St. Powers Walk Cresent","0851183546","0000002"));
        list.getUserList().add(new User(3, "David Jones", "DavidJones@gmail.com", "5 St. Powers Walk Cresent","0852580846","0000003"));
        list.getUserList().add(new User(4, "Wellington Waters V", "damian.lockman@gmail.com", "5135 Bartoletti Lodge Suite 372 Ebertburgh, WI 78211","1000079613", "1013507"));
        list.getUserList().add(new User(5, "Antone Kautzer III", "mayert.hollie@gmail.com", "29634 White Curve Apt. 446 East Nikolas, AL 28572","1000020243", "1050581"));
        list.getUserList().add(new User(6, "Prof. Gerald Williamson", "yasmin81@gmail.com", "1084 Ella Point Suite 506 Karinebury, WV 32343-7303","1000084822", "1057896"));
        list.getUserList().add(new User(7, "Mrs. Destiny Bogan PhD", "gerlach.jeanett@gmail.com", "7844 Kilback Common New Consuelo, IN 01019","1000006060", "1070956"));
        list.getUserList().add(new User(8, "Libby Roberts", "elyse57@gmail.com", "8516 Carter Dale Apt. 211 Walkerland, AZ 37809-7356","1000053367", "1040506"));
        list.getUserList().add(new User(9, "Brendan Rau", "tamia.torp@gmail.com", "30766 Osbaldo Union Apt. 063 New Leoview, NJ 78208-7355","1000057713", "1050992"));
        list.getUserList().add(new User(10, "Prof. Easter Sipes", "jonathan.wyman@gmail.com", "22587 Nelson Vista Suite 809 North Kris, UT 57011-6075","1000081369", "1023142"));
        list.getUserList().add(new User(11, "Jeanne Paucek", "braeden33@gmail.com", "3845 Schinner Fort North Laneshire, ME 55598","1000088943", "1068818"));
        list.getUserList().add(new User(12, "Mrs. Estefania Romaguera", "veronica62@gmail.com", "8878 Zora Wall Apt. 524 New Velmamouth, WI 17074-8689","1000075419", "1054956"));
        list.getUserList().add(new User(13, "Talia Altenwerth", "araceli24@gmail.com", "6951 Reichel Knoll Elyssaborough, NV 80639","1000024379", "1008242"));
        list.getUserList().add(new User(14, "Kelly Hammes", "mckenzie.tracy@gmail.com", "42685 Lynch Court Vivianeborough, UT 51230-6238","1000024443", "1030633"));
        list.getUserList().add(new User(15, "Mr. Trenton Will DVM", "jaskolski.addie@gmail.com", "6228 Amparo Ridges Suite 658 East Clyde, IL 62176-1774","1000007174", "1005685"));
        list.getUserList().add(new User(16, "Rory Jenkins", "franz32@gmail.com", "7943 Quincy Overpass Apt. 581 Hillsfurt, KS 22616","1000065732", "1002568"));
        list.getUserList().add(new User(17, "Buck Padberg MD", "bode.forrest@gmail.com", "81012 Murazik Valleys Melynafurt, NY 00145-7298","1000089025", "1078788"));
        list.getUserList().add(new User(18, "Lonnie Will", "isaac.legros@gmail.com", "2001 Runte Inlet Apt. 176 Easterland, RI 22292","1000067727", "1036567"));
        list.getUserList().add(new User(19, "Jaeden Ledner", "finn.heller@gmail.com", "04236 Roosevelt Centers Apt. 631 Port Hazel, TX 01233-0470","1000047791", "1046300"));
        list.getUserList().add(new User(20, "Mabel Gerlach III", "oschroeder@gmail.com", "683 Ezequiel Meadow Hoppeview, DE 94432","1000073590", "1033236"));
    }
    
    public Users getAllUsers() 
    {
        return list;
    }
    
    public User getUserByUserId(Integer userId) 
    {
        return list.getUserList()
        		.stream()
        		.filter(u -> u.getUserId() == userId)
        		.findFirst()
        		.orElseGet(null);
    }
    
    public boolean deleteUserByUserId(Integer userId) 
    {
        return list.getUserList().removeIf(u -> u.getUserId() == userId);
    }
    
    public void addUser(User user) {
        list.getUserList().add(user);
    }
}
