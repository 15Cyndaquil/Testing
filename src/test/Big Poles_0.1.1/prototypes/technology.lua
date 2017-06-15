--
-- Created by IntelliJ IDEA.
-- User: Cyndaquil
-- Date: 6/13/2017
-- Time: 5:10 PM
-- To change this template use File | Settings | File Templates.
--

data:extend(
    {
        {
            type = "technology",
            name = "electric-energy-distibution-3",
            icon = "__base__/graphics/technology/electric-energy-distribution.png",
            effects =
            {
                {
                    type = "unlock-recipe",
                    recipe = "bigger-electric-pole-1",
                },
                {
                    type = "unlock-recipe",
                    recipe = "bigger-electric-pole-2",
                },
                {
                    type = "unlock-recipe",
                    recipe = "bigger-electric-pole-3",
                },
                {
                    type = "unlock-recipe",
                    recipe = "bigger-electric-pole-4",
                }
            },
            prerequisites = {"electric-energy-distribution-2"},
            unit =
            {
                count = 150,
                ingredients =
                {
                    {"science-pack-1", 1},
                    {"science-pack-2", 1},
                    {"science-pack-3", 1},
                },
                time = 60
            },
        },
    }
)