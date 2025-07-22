| Routing Key                | Exchange → Queue                    | DLX → DLQ                    |
| -------------------------- | ----------------------------------- | ---------------------------- |
| `applicant-data-retention` | `exchange` → `data-retention-queue` | `dlx` → `data-retention-dlq` |
| `applicant-reporting-info` | `exchange` → `reporting-info-queue` | `dlx` → `reporting-info-dlq` |
