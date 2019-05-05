package virusSimulation;

import java.util.*;

public class Infect {
	// int infectedPeopleNum;
	Random random;
	List<Integer> resOfInfectedPpl;

	/**
	 * This is the constructor of the class test
	 */
	public Infect() {
		random = new Random();
		// infectedPeopleNum = 0;
		resOfInfectedPpl = new ArrayList<>();
	}

	/**
	 * This function aims calculate the number of infected people after each
	 * iteration
	 * 
	 * @param q: the queue of people
	 * @param probability: probability of spread of virus
	 * @param days: the number of iterations of virus infection
	 * @param adjList: the list contains all People vertex
	 * @return The list of number of infected people after each iteration
	 */
	public List<Integer> BFS(Queue<People> q, Virus virus, int days, List<People> adjList) {
		for (int j = 0; j < days; j++) {
			int size = q.size();
			// System.out.println("Size: " + size);
			for (int i = 0; i < size; i++) {
				People current = q.poll();
				if (current.isHealthy == true || current.isTreated == true) {
					continue;
				}
				// List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
				List<People> netWork = current.getSocialNetwork();
				List<People> network = new ArrayList<>();
				q.offer(current);
				for (People each : netWork) {
					// System.out.println("nei "+each.getName());
					int val = netWork.indexOf(new People(each.getName()));
					People toPut = adjList.get(val);
					// System.out.println("toput "+toPut.getName());
					network.add(toPut);
				}
				// System.out.println("network-> " + netWork.size());
				for (People each : netWork) {
					if (each.isTreated == true || each.isHealthy == false) {
						continue;
					}
					// double eachResistance = each.getResistence();
					double overall = virus.getProbability();

					int randomNumber = random.nextInt(100);
					if (randomNumber <= overall * 100) {
						// .infectedPeopleNum++;
						each.gotInfected();
						q.offer(each);
					}

				}
			}
			resOfInfectedPpl.add(q.size());
		}
		return resOfInfectedPpl;
	}

	public List<Integer> BFSwithKShell(Queue<People> q, Virus virus, int days, List<People> adjList, int k) {
		/* K shell */
		List<People> kShellPpl = treatKShellPpl(adjList, k);
		return BFS(q, virus, days, kShellPpl);
	}

	public List<Integer> BFSwithTreatment1(Queue<People> q, Virus virus, int days, List<People> adjList,
			List<People> treatment) {
		/* most edges */
		if (days <= 3) {
			return BFS(q, virus, 3, adjList);
		} else {
			for (int j = 0; j < days; j++) {
				int size = q.size();
				// System.out.println("Size: " + size);
				if (j == 1) {
					giveTreatMent(treatment);
				}
				for (int i = 0; i < size; i++) {
					People current = q.poll();
					if (current.isHealthy == true || current.isTreated == true) {
						continue;
					}
					// List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
					List<People> netWork = current.getSocialNetwork();
					List<People> network = new ArrayList<>();
					q.offer(current);
					for (People each : netWork) {
						// System.out.println("nei "+each.getName());
						int val = netWork.indexOf(new People(each.getName()));
						People toPut = adjList.get(val);
						// System.out.println("toput "+toPut.getName());
						network.add(toPut);
					}
					// System.out.println("network-> " + netWork.size());
					for (People each : netWork) {
						if (each.isTreated == true || each.isHealthy == false) {
							continue;
						}
						// double eachResistance = each.getResistence();
						double overall = virus.getProbability();

						int randomNumber = random.nextInt(100);
						if (randomNumber <= overall * 100) {
							// infectedPeopleNum++;
							each.gotInfected();
							q.offer(each);
						}
					}
				}

				int counter = 0;
				while (!q.isEmpty() && (counter < 30)) {

					People cur = q.poll();
					if (!cur.isHealthy && !cur.isTreated) {
						cur.isTreated = true;
						cur.isHealthy = true;
						// infectedPeopleNum --;
						counter++;

					}

				}
				resOfInfectedPpl.add(q.size());
			}

		}
		return resOfInfectedPpl;

	}

	public List<People> findTopKSocialPeople(List<People> adjList, int k) {
		List<People> answer = new ArrayList<>();
		PriorityQueue<People> pq = new PriorityQueue<People>(k + 1, new comparePeople());
		for (People each : adjList) {
			pq.offer(each);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		while (!pq.isEmpty()) {
			answer.add(pq.poll());
		}
		return answer;
	}

	public void giveTreatMent(List<People> adjList) {
		for (People each : adjList) {
			each.isTreated = true;
			each.isHealthy = true;
			// infectedPeopleNum--;
		}
	}
	public void giveTreatMent(People each) {
		each.isTreated = true;
		each.isHealthy = true;
			// infectedPeopleNum--;
	}
	public List<Integer> BFSwithTreatment2(Queue<People> q, Virus virus, int days, List<People> adjList) {
		/* immune with treatement */
		if (days <= 3) {
			return BFS(q, virus, 3, adjList);
		} else {
			for (int j = 0; j < days; j++) {
				int size = q.size();
				// System.out.println("Size: " + size);
				if (j == 1) {
					List<People> prevent = findTopKSocialPeople(adjList, 10);
					giveTreatMent(prevent);
				}
				for (int i = 0; i < size; i++) {
					People current = q.poll();
					if (current.isHealthy == true || current.isTreated == true) {
						continue;
					}
					// List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
					List<People> netWork = current.getSocialNetwork();
					List<People> network = new ArrayList<>();
					q.offer(current);
					for (People each : netWork) {
						// System.out.println("nei "+each.getName());
						int val = netWork.indexOf(new People(each.getName()));
						People toPut = adjList.get(val);
						// System.out.println("toput "+toPut.getName());
						network.add(toPut);
					}
					// System.out.println("network-> " + netWork.size());
					for (People each : netWork) {
						if (each.isTreated == true || each.isHealthy == false) {
							continue;
						}
						// double eachResistance = each.getResistence();
						double overall = virus.getProbability();

						int randomNumber = random.nextInt(100);
						if (randomNumber <= overall * 100) {
							// infectedPeopleNum++;
							each.gotInfected();
							q.offer(each);
						}

					}
				}
				int counter = 0;
				while (!q.isEmpty() && (counter < 30)) {
					People cur = q.poll();
					cur.isTreated = true;
					cur.isHealthy = true;
					// infectedPeopleNum --;
					counter++;
				}

				resOfInfectedPpl.add(q.size());
			}
		}
		return resOfInfectedPpl;
	}

	private List<People> treatKShellPpl(List<People> adjList, int k) {
		List<People> answer = adjList;
		for (People each : answer) {
			if (each.getSocialNetwork().size() == k) {
				giveTreatMent(each);
			}
		}
		return answer;
	}

	public static class comparePeople implements Comparator<People> {

		public int compare(People a, People b) {
			int sizeA = a.getSocialNetwork().size();
			int sizeB = b.getSocialNetwork().size();
			return Integer.compare(sizeA, sizeB);
		}

	}
}
