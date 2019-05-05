
package virusSimulation;

import java.util.*;
import virusSimulation.Plot.Data;
import java.awt.Color;
import java.io.IOException;

public class Simulation {
	/*
	 * main method that runs the virus simulation
	 * 1st argument: virus infectious probability
	 * 2nd argument: seed of the initial infected people
	 * 3rd argument: number of days to simulate
	 * 4th argument: number of times for simulation
	 * @return: percentage of infected people changed with number of days 
	 */
	public static void main(String[] args) {
		int argc = args.length;
		FileReaderTxt myText = new FileReaderTxt("facebook_combined (1).txt");
		List<String> textList = myText.getAllLines();
		AdjPreprocess preprocessMachine = new AdjPreprocess();
		
		Scanner newScanner = new Scanner(System.in);
		System.out.println("Please provide the probability of the disease: ");
		double probability = newScanner.nextDouble();
		Virus virus = new unmutableVirus(probability,"flu");
		System.out.println("Please provide the number of people initially be inffected: ");
		int seedNum = newScanner.nextInt();
		System.out.println("Please provide the number of days you want to simulate:");
		int days = newScanner.nextInt();
		
		/* preprocess to adjacency list */
		List<People> adjList = preprocessMachine.adjPreprocess(textList);
		List<People> adjList2 = preprocessMachine.adjPreprocess(textList);
		List<People> adjList3 = preprocessMachine.adjPreprocess(textList);
		List<People> adjList4 = preprocessMachine.adjPreprocess(textList);
		List<People> adjList5 = preprocessMachine.adjPreprocess(textList);
		List<People> adjList6 = preprocessMachine.adjPreprocess(textList);
		List<People> adjList7 = preprocessMachine.adjPreprocess(textList);
		List<People> adjList8 = preprocessMachine.adjPreprocess(textList);
		int totalPeople = preprocessMachine.getTotalPeople();
		
		/* process user input */
		/* virus probability */
		//double probability = Double.parseDouble(args[0]);
		/* seed */
		//int seedNum = Integer.parseInt(args[1]);
		/* how many days? */
		//int days = Integer.parseInt(args[2]);
		Random random = new Random();
		
		/* how many simulation times */
		//int times = Integer.parseInt(args[3]);
			/* create seed into queue */
			Queue<People> q = new LinkedList<>();
			Queue<People> q2 = new LinkedList<>();
			Queue<People> q3 = new LinkedList<>();
			Queue<People> q4 = new LinkedList<>();
			Queue<People> q5 = new LinkedList<>();
			Queue<People> q6 = new LinkedList<>();
			Queue<People> q7 = new LinkedList<>();
			Queue<People> q8 = new LinkedList<>();
			List<People> randomSelect = new ArrayList<>();
			boolean[] used = new boolean[totalPeople];
			Infect bfs = new Infect();
			Infect bfs2 = new Infect();
			Infect bfs3 = new Infect();
			Infect bfs4 = new Infect();
			Infect bfs5 = new Infect();
			Infect bfs6 = new Infect();
			Infect bfs7 = new Infect();
			Infect bfs8 = new Infect();
			while (q.size() < seedNum) {
				int val = random.nextInt(totalPeople);
				if (!used[val]) {
					People toPut = adjList.get(val);
					People toPut2 = adjList2.get(val);
					People toPut3 = adjList3.get(val);
					People toPut4 = adjList4.get(val);
					People toPut5 = adjList5.get(val);
					People toPut6 = adjList6.get(val);
					People toPut7 = adjList7.get(val);
					People toPut8 = adjList8.get(val);
					toPut.gotInfected();
					toPut2.gotInfected();
					toPut3.gotInfected();
					toPut4.gotInfected();
					toPut5.gotInfected();
					toPut6.gotInfected();
					toPut7.gotInfected();
					toPut8.gotInfected();
					//System.out.println("check==>" + toPut.getSocialNetwork().size());
					randomSelect.add(toPut2);
					q.offer(toPut);
					//bfs.infectedPeopleNum ++;
					q2.offer(toPut2);
					//bfs2.infectedPeopleNum ++;
					q3.offer(toPut3);
					//bfs3.infectedPeopleNum ++;
					q4.offer(toPut4);
					q5.offer(toPut5);
					q6.offer(toPut6);
					q7.offer(toPut7);
					q8.offer(toPut8);
				}
				used[val] = true;
			}
			
			List<Integer> resOfInfectedPpl = bfs.BFS(q, virus, days, adjList);
			List<Integer> resOfInfectedPp2 = bfs2.BFSwithTreatment1(q2,virus, days,adjList2,randomSelect);
			List<Integer> resOfInfectedPp3 = bfs3.BFSwithTreatment2(q3,virus, days,adjList3);
	//		System.out.println("total people: " + totalPeople);
	//		/* run bfs */
	//		for (int i = 0; i < days; i++) {
	//			infectedPeopleNum += bfs.BFS1Round(q, probability);
	//			System.out.println(infectedPeopleNum);
	//		}
			List<Integer> resOfInfectedPp4 = bfs4.BFSwithKShell(q4, virus, days, adjList4, 20);
			List<Integer> resOfInfectedPp5 = bfs5.BFSwithKShell(q5, virus, days, adjList5, 30);
			List<Integer> resOfInfectedPp6 = bfs6.BFSwithKShell(q6, virus, days, adjList6, 40);
			List<Integer> resOfInfectedPp7 = bfs7.BFSwithKShell(q7, virus, days, adjList7, 50);
			List<Integer> resOfInfectedPp8 = bfs8.BFSwithKShell(q8, virus, days, adjList8, 60);
			
		
			System.out.println(resOfInfectedPpl);
			System.out.println(resOfInfectedPp2);
			System.out.println(resOfInfectedPp3);
			System.out.println(resOfInfectedPp4);
			System.out.println(resOfInfectedPp5);
			System.out.println(resOfInfectedPp6);
			System.out.println(resOfInfectedPp7);
			System.out.println(resOfInfectedPp8);
			
			/* plot */
			Plot plot = Plot.plot(Plot.plotOpts().
			        title("Virus Simulation").
			        legend(Plot.LegendFormat.BOTTOM)).
			    xAxis("x", Plot.axisOpts().
			        range(0, days)).
			    yAxis("y", Plot.axisOpts().
			        range(0, 1));
			Data d = Plot.data();
			for (int i = 0; i < resOfInfectedPpl.size(); i++) {
				d = d.xy(i, resOfInfectedPpl.get(i) / (double) totalPeople);
			}
			plot.series("Without Treatment", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.GREEN).
			            color(Color.BLACK));
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp2.size(); i++) {
				d = d.xy(i, resOfInfectedPp2.get(i) / (double) totalPeople);
			}
			plot.series("Most-edge with everyday treatment", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.BLUE).
			            color(Color.BLACK));
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp3.size(); i++) {
				d = d.xy(i, resOfInfectedPp3.get(i) / (double) totalPeople);
			}
			plot.series("Most-edge with everyday treatment + Immunization", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.RED).
			            color(Color.BLACK));
			
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp4.size(); i++) {
				d = d.xy(i, resOfInfectedPp4.get(i) / (double) totalPeople);
			}
			plot.series("KShell 20", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.PINK).
			            color(Color.BLACK));
			
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp5.size(); i++) {
				d = d.xy(i, resOfInfectedPp5.get(i) / (double) totalPeople);
			}
			plot.series("KShell 30", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.ORANGE).
			            color(Color.BLACK));
			
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp6.size(); i++) {
				d = d.xy(i, resOfInfectedPp6.get(i) / (double) totalPeople);
			}
			plot.series("KShell 40", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.YELLOW).
			            color(Color.BLACK));
			
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp7.size(); i++) {
				d = d.xy(i, resOfInfectedPp7.get(i) / (double) totalPeople);
			}
			plot.series("KShell 50", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.GRAY).
			            color(Color.BLACK));
			
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp8.size(); i++) {
				d = d.xy(i, resOfInfectedPp8.get(i) / (double) totalPeople);
			}
			plot.series("KShell 60", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.BLACK).
			            color(Color.BLACK));
			
			try {
				plot.save("virus_simulation", "png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			
//			/* plot */
//			plot = Plot.plot(Plot.plotOpts().
//			        title("Virus Simulation").
//			        legend(Plot.LegendFormat.BOTTOM)).
//			    xAxis("x", Plot.axisOpts().
//			        range(0, days)).
//			    yAxis("y", Plot.axisOpts().
//			        range(0, 1));
//			d = Plot.data();
//			for (int i = 0; i < resOfInfectedPp2.size(); i++) {
//				d = d.xy(i, resOfInfectedPp2.get(i) / (double) totalPeople);
//			}
//			plot.series("Data", d, Plot.seriesOpts().
//			            marker(Plot.Marker.DIAMOND).
//			            markerColor(Color.GREEN).
//			            color(Color.BLACK));
//	
//			try {
//				plot.save("virus_simulation" + "_" + 2, "png");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace(); 
//			}
//			/* plot */
//			plot = Plot.plot(Plot.plotOpts().
//			        title("Virus Simulation").
//			        legend(Plot.LegendFormat.BOTTOM)).
//			    xAxis("x", Plot.axisOpts().
//			        range(0, days)).
//			    yAxis("y", Plot.axisOpts().
//			        range(0, 1));
//			d = Plot.data();
//			for (int i = 0; i < resOfInfectedPp3.size(); i++) {
//				d = d.xy(i, resOfInfectedPp3.get(i) / (double) totalPeople);
//			}
//			plot.series("Data", d, Plot.seriesOpts().
//			            marker(Plot.Marker.DIAMOND).
//			            markerColor(Color.GREEN).
//			            color(Color.BLACK));
//	
//			try {
//				plot.save("virus_simulation" + "_" + 3, "png");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace(); 
//			}
	}

}