
import java.util.*;
class Job implements Comparable<Job>
{
    int id, startTime, duration, finishTime, difficultyLevel;
    public int compareTo(Job other)
    {
        return Integer.compare(this.finishTime, other.finishTime);
    }
}
public class Online_2_Que_1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Job> jobs = new ArrayList<>();

        for(int i = 0; i < N; i++)
        {
            Job job = new Job();
            job.startTime = sc.nextInt();
            job.duration = sc.nextInt();
            job.difficultyLevel = sc.nextInt();
            job.finishTime = job.startTime + job.duration;
            job.id = i + 1;
            jobs.add(job);
        }

        int paymentForEachJob = sc.nextInt();
        int workStartAt = sc.nextInt();
        int workEndAt = sc.nextInt();
        bestPossibleJobs(paymentForEachJob, workStartAt, workEndAt, jobs);
    }

    public static void bestPossibleJobs(int paymentForEachJob, int workStartAt, int workEndAt, List<Job> jobs)
    {
        Collections.sort(jobs);
        int chosenIndex = -1;
        List<Job> selectedJobs = new ArrayList<>();
        for(int i = 0; i < jobs.size(); i++)
        {
            if(jobs.get(i).startTime >= workStartAt)
            {
                chosenIndex = i;
                selectedJobs.add(jobs.get(i));
                break;
            }
        }

        for(int i = 1; i < jobs.size(); i++)
        {
            if((jobs.get(i).startTime >= jobs.get(chosenIndex).finishTime) && (jobs.get(i).finishTime <= workEndAt))
            {
                chosenIndex = i;
                selectedJobs.add(jobs.get(i));
            }
        }

        System.out.println("Recommended jobs: ");
        for(Job j : selectedJobs)
        {
            System.out.println("job" + j.id + " starts at " + j.startTime + ", ends at " + j.finishTime + ", difficulty " + j.difficultyLevel);
        }
        System.out.println("expected earning " + paymentForEachJob * selectedJobs.size() + " dollars");
    }
}
/*
6
5 4 4
13 1 1
4 8 4
11 2 3
10 2 5
16 1 2
20
10 14

3
16 1 2
15 1 3
14 2 1
12
15 18
 */
