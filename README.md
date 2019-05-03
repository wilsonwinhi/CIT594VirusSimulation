# CIT594VirusSimulation

The goal of the application is to perform simulation of a spreading process of a fatal virus within a network.  Such simulation can be of great value when applied to fields like public health and information security.
In addition to the spread simulation, the simulation also takes intervention process into consideration. Through simulation, the application can help to develop the a strategy which can effectively and efficiently slow down the spreading and eventually prevent the virus from further spreading.

## Description of the problem
	The whole process is composed of steps as followed:
a.	Network Establishment

b.	Virus Parameter Setting

c.	Infective Object Parameter Setting

d.	Early Stage of Spreading (without intervention)

e.	Intervention Strategy Development

f.	Simaltanious Simulation of Spreading Process and Intervention Strategy

g.	Result and Conclusion

## Network Establishment
The application will use an undirected graph from Stanford large dataset collection (http://snap.stanford.edu/data/#socnets) to establish the network and simulate the interaction and relationships(edges) between objects(nodes) within the network.

## Virus Paratemer Setting
Establishing the virus parameters is vital to the simulation process. The virus has two main parameter: the probability of infection and the probability of of mutation at the end of each round. The probability of infection affects virus ability to infect an unaffected and non-immune object connected to the host. The probability of mutation determines whether the virus’ parameters will change at the end of each round, and will be effective immediately at the start of the next round.

## Infective Object Parameter Setting
Similar to the virus, the parameters of infective object also need to be determined. The parameters of each object includes the status of the object(healthy, infected, treated/imune) and the adjacent nodes/objects. The adjacent nodes shows the node’s social-significance, and the status determines whether the object is available to virus or pending curation.
## Early Stage of Spreading(without intervention)
Like all real-life viruses, the initial spreading is undetected and uncontained. That can give the virus a “head start” than the intervention until the spreading reaches a certain level. The application can determine the initial seeding randomly and kick off the spreading.
## Intervention Strategy Development
There are three strategy to choose from: 
1.	Treating/Immune certain vertives with highest social-significance.
2.	K-Shell Method
3.	Treat/immune the nodes with highest clustering coefficient.

## Simaltanious Simulation of Spreading Process and Intervention Strategy
This stage of simulation is the one with the spreading process and intervention going on at the same time. With the infection and intervention fighting each other at the same time, it ends with the virus is eliminated (virus fail) or all objects are infected(intervention fail).
## Result and  Conclusion
The final step is to conclude the simulation by providing statistics of the simulation(e.g. maximum number of simultaneous infected object, number of rounds) to help determining whether the intervention strategy is effective and efficient enough and visualized data to illustrate the relationship between growth rate of the disease and its infectious probability. We also wish to analyze the effectiveness of different invention method and tries to provide a best disease treatment strategy.

# Data Strcutures to Use
## Graph
The group will import hundreds of edges (communications between two people) and transform them into a graph in the form of adjacent lists. The “graph” data structure will implemented by the group. 
## Queue
The main strategy to perform the “infection” is to use the algorithm of “Breadth First Search” since the group want to simulate the separation of virus for each day. In the programming, each day can be treated as each iteration and bfs provides a way to deal with the nodes at the same level at the same time. In order to perform bfs, the data structure queue is needed. The group will directly use the interface Queue in the java build-in library.
## HashMap
The group also needs to calculate the probability of people are infected. So after each iteration, the group still needs to traverse the graph again to statistical the number of healthy people, unhealthy people and treated people. In this case, The data structure of HashMap<People, Integer> is a good choice. The group will directly use the class HashMap in the java build-in library.
## List 
Since the graph is in the form of adjacent list, data structure List is necessary. Each neighbor will be stored in the global variable List<People> socialNetwork. The group will directly use the interface List in the java build-in library.


![alt text](https://github.com/wilsonwinhi/CIT594VirusSimulation/blob/master/virus_simulation.png)
