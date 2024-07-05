### Add local repo to github

https://docs.github.com/en/get-started/importing-your-projects-to-github/importing-source-code-to-github/adding-locally-hosted-code-to-github

1. Initialize local repo
```
git init
```

2. Create repo on github with same local project name

3. Link local repo to github repo
```
git remote add origin  <REMOTE_URL> 
```

4. Commit local files to remote git 
```
git add .
git commit -m "inital commit"
git push --set-upstream origin master
```
