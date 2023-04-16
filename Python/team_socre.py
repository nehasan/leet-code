import string
import re

class TeamScore:

    def parseTeam(self, scores: string=[]) -> None:

        teams = dict()
        for score in scores:
            # print(score)
            tokens = score.split(":")
            # print(tokens[0])
            # print(tokens[1])

            teamOne = re.sub("[0-9]", "", tokens[0]).strip()
            scoreOne = re.sub("[a-zA-Z]", "", tokens[0]).strip()
            # print(f"{teamOne} : {scoreOne}")

            teams[teamOne] = (teams.get(teamOne) + int(scoreOne)) if teams.get(teamOne) else int(scoreOne)
            
            teamTwo = re.sub("[0-9]", "", tokens[1]).strip()
            scoreTwo = re.sub("[a-zA-Z]", "", tokens[1]).strip()
            # print(f"{teamTwo} : {scoreTwo}")
            
            teams[teamTwo] = (teams.get(teamTwo) + int(scoreTwo)) if teams.get(teamTwo) else int(scoreTwo)
            # print(teams)
        
        teams = { k: v for k, v in sorted(teams.items(), key=lambda item: item[1], reverse=True) }
        print(teams)


obj = TeamScore()
scores = [
    "Atletico Madrid 2:3 Real Madrid",
    "Real Madrid 4:1 PSG",
    "Barcelona FC 3:2 Manchester City",
    "Liverpool FC 20:10 Arsenal"
]
obj.parseTeam(scores)