# STEPS

## 1- Requirement Clarification (~5 mins)
- User/Customers
  - Who will use the system ?
  - How the system will be used ?
- Scale (read.write)
  - How many req/query per sec ?
  - How much data queried per sec ?
  - Can there be spikes in traffic ?
- Performance
  - What is expected write-to-read delay ?
  - What is expected p99 latency for read queries ?
- Cost
  - Should design minimize cost for development ?
  - Should design minimize cost of maintenance ?

### Functional Requirements
- 

### Non-Functional Requirements
- Scalable
- High Performance (low latency, high throughput)
- Highly Available (services network/hardware failures)



## 2- Estimations  (~5 mins)
-



## 3- High Level Design  (~5 mins)
-


## 4- Deep Dive  (~20 mins)
- API Design
- Data Model
  - What we store ?
  - Where we store ? SQL vs NoSQL database, cache
  - How we store ? write as is and aggreagated ?






## 5- Bottlenecks (~5 mins)
- Usage patterns
  - Service may be mostly used during some part of the day.
  - Spikes ?
- 



