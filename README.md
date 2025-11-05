# Vehicle-parking-management-system

## Overview

The Vehicle Parking Management System is a web-based application designed to efficiently manage vehicle parking operations. It records the vehicle number, type, and entry/exit time, automatically calculates parking charges (₹25/hour), and manages available parking slots dynamically.

## Features

 Vehicle Entry: Add new vehicles with details (number, type, entry date & time).

 Slot Management: Automatically assigns an available parking slot.

 Exit Operation: On vehicle exit, system requests exit date & time.

 Charge Calculation: Calculates total parking cost (₹25 per hour).

 View Records: Displays current parked vehicles and past transactions.

 Data Management: Supports clearing or resetting slot data.

## Technologies Used

Frontend: HTML, CSS, JavaScript 

Backend: Springboot, Microservices

Database: MySQL / MongoDB / LocalStorage 

## Usage Flow

Launch the app and open the Entry Form.

Enter vehicle details:

Vehicle Number

Type (Car/Bike/etc.)

Entry Date & Time

System assigns an available slot.

When the vehicle exits, enter exit date & time.

System calculates:  Total Time = Exit Time - Entry Time  
Total Cost = Total Hours × ₹25  

## Example Calculation
Entry Time	Exit Time	Duration	Amount
10:00 AM	12:30 PM	2.5 hours	₹62.50

## Future Enhancements

Add QR code receipts for parking tickets

Enable online payment integration

Real-time slot availability display
