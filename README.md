# CIT594VirusSimulation

 ## Group Members
| <a href="https://github.com/pedoe" target="_blank">**Pedoe**</a> | <a href="https://github.com/szhongyu" target="_blank">**szhongyu**</a> | <a href="http://github.com/wilsonwinhi" target="_blank">**Wilsonwinhi**</a> |
| :---: |:---:| :---:|
| [![FVCproductions](https://avatars3.githubusercontent.com/u/14311331?s=200&v=4)](http://fvcproductions.com)    | [![FVCproductions](https://avatars2.githubusercontent.com/u/17982036?s=200&v=4)](http://fvcproductions.com)  | [![FVCproductions](https://avatars1.githubusercontent.com/u/17274967?s=200&v=4)](http://fvcproductions.com) |
| <a href="https://github.com/pedoe" target="_blank">`github.com/pedoe`</a> | <a href="http://github.com/garatee" target="_blank">`github.com/garatee`</a> | <a href="http://github.com/wilsonwinhi" target="_blank">`github.com/wilsonwinhi`</a> | 

**Name**: Chih-Sheng Huang &nbsp;&nbsp;   
**Eniac username** : huangcs  

**Name**: Chen-Ping Liao &nbsp;&nbsp;   
**Eniac username** : kcliao

**Name**: Wei-Cheng Lin &nbsp;&nbsp;   
**Eniac username** : linwc


## List of Submitted Source Files
* virtual_memory_controller.h
* virtual_memory_controller.c
* FIFO.h
* FIFO.c
* LRU.h
* LRU.c
* clock_algorithm.h
* clock_algorithm.c
* page_table.h
* page_table.c
* swap_file.h
* swap_file.c
* tlb.h
* tlb.c
* virtual_space.h
* virtual_space.c
* Makefile
* README.md


## Overview of work accomplished
In this project, we implemented an in-memory simulation of the Memory Management Unit and Page Replacement.  
The core functions are as follows (see **interfaces.h**):
  ```
  int pemmu_malloc(int type, int number);
  int pemmu_read_data(int address, void * data, int size);
  int pemmu_write_data(int address, void * data, int size);
  int pemmu_free(int address);
  ```
The configurations are as follows (see **interfaces.h**)
  ```
  int page_size;
  int data_size;
  int max_page_entries;
  int virtual_memory_size;
  int max_virtual_pages;
  int physical_memory_size;
  int max_physical_pages;
  int max_swap_memory_pages;
  bool tlb_enabled;
  int max_tlb_entries;
  ```
When **pemmu_malloc()** is called, our program first searches through virtual memory (**virtual_space.h**) to look for available space based on first-fit memory allocation algorithm. Virtual memory is implemented based on a linked list structure. Upon success, the virtual address is returned.  Upon failure, -1 is returned.  

After obtaining the virtual address through the return value of **pemmu_malloc()**, a user can read and write data within the malloced space using **pemmu_read_data()** and **pemmu_write_data()**.  When physical memory is full, physical memory frames are evicted to swap file based on the replacement policy set by the user (see below).  Penn MMU first looks at TLB to find the page.  If it is not found, MMU then looks at the page table.  If it still does not exist in the page table, it loads the specific page from the swap file into physical memory.  At last, it updates the page table and the TLB according to the changes.

Replacement policy includes
- First In First Out (FIFO)
- Clock Algorithm (CLOCK)
- Least Recently Used (LRU)

After the user is done, he/she can call **pemmu_free()** to free the space.
 
## Description of code and code layout
We have linkedlist implemented in our majority of data structure. Page table maintains two linkedlists: one for storing the actual conversion information, and the other for performing an update according to a replacement policy. Similarly, TLB has a similar structure with a smaller size and uses the specified LRU replacement policy. Virtual memory serves as indication if such memory is in used. Together, we can easily tell the mapping between virtual memory and physical memory and do the read and write operation. If the memory has been modified and was selected to be evicted, we write it into the swap file.

1. **virtual_space.c**:  
The virtual memory is a linkedlist that supports split and merge operation. The **list_first_fit()** method will find the first node that is not in use and has enough space that does not exceed a page side, then perform a split operation. When called free, the node will be marked as in used and merge with neighboring nodes.

2. **LRU.c**:  
LRU is a linkedlist that provides a API call **LRU_update()**. It will bring the most recently used page to the front and if the size exceeds capacity, it will kick out the least recently used one.

3. **clock_algorithm.c**:  
clock_algorithm is a linkedlist which updates its node to find the evict page according to clock algorithm.

4. **FIFO.c**:  
Similar to LRU.c and clock_algorithm.c with the FIFO policy.

5. **page_table.c**:  
page_table is a linkedlist that stores all the information we need for conversion between virtual and physical memory. It also has one of the above three data structures to determine if a page fault has occurred.

6. **TLB.c**  
Similar to page_table, only it has less size and always uses the LRU replacement policy. Note that when a page is evicted, it will first sync with the page table to make sure everything is up to date.

7. **swap_file.c**  
Provides read write operation to a local swap_file.

## Extra credit
We have completed all of the analysis required for extra credit.



