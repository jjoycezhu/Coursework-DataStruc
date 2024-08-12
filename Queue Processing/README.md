# Project 1: Queue Processing
This project simulates the operating system’s selection of processes to send to the CPU.

# Part A
The program reads one line from the console representing the process list with resources:

```bash
Enter list to be processed: 
P1(A);P2(B);P3(B,C);P4(C);P5(A,B,C);P6(B,C);P7(A);P8(A);P9(B);P10(C) 
```
Each process will require 1 or more the resources A, B and C. Some processes will require only B for example, while another might require A and B, yet another B and C. If the resource is available, the process can be started. If one or more of the resources are unavailable, then the process must wait one cycle. A process that is started will only use a resource for one cycle. A process can only start if all the previous processes have been started. Here is a chart dictating the case above:

<img width="520" alt="Screenshot 2024-08-12 at 5 35 11 PM" src="https://github.com/user-attachments/assets/e1745e9c-8b3f-45c0-9168-87c3d910cfe0">

```bash
Total number of cycles needed: 6
```
[Test Cases - Project1.txt](https://github.com/user-attachments/files/16592183/Test.Cases.-.Project1.txt)
# Part B
Randomly generates and executes a list of 20 processes with randomly select 1,2 or 3 resources (A,B,C) for each process. At the end of each cycle (regardless of how many processes were run), add 2 more process to the end of the list with 1,2,3 random resources. Output the number of cycles needed to empty the list of processes, but if the list does not empty by cycle 1000, then output the number of processes left (length of the list). Output the length of the list of processes every 100th cycle to watch its growth:

```bash
Length of processes at cycle 100: 30
Length of processes at cycle 200: 55
Length of processes at cycle 300: 72
Length of processes at cycle 400: 88
Length of processes at cycle 500: 107
Length of processes at cycle 600: 125
Length of processes at cycle 700: 142
Length of processes at cycle 800: 163
Length of processes at cycle 900: 177
Length of processes at cycle 1000: 192
We have a total of 192 left.
```
