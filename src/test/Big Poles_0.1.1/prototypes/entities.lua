--
-- Created by IntelliJ IDEA.
-- User: Cyndaquil
-- Date: 6/13/2017
-- Time: 5:35 PM
-- To change this template use File | Settings | File Templates.
--



data:extend(
    {
        --Bigger Electric Pole 1
        {
            type = "electric-pole",
            name = "bigger-electric-pole-1",
            icon = "__base__/graphics/icons/big-electric-pole.png",
            flags = {"placeable-neutral", "player-creation"},
            minable = {hardness = 0.2, mining_time = 0.5, result = "bigger-electric-pole-1"},
            max_health = 150,
            corpse = "medium-remnants",
            resistances =
            {
                {
                    type = "fire",
                    percent = 100
                }
            },
            collision_box = {{-1.65, -1.65}, {1.65, 1.65}},
            selection_box = {{-2, -2}, {2, 2}},
            drawing_box = {{-1, -3}, {1, 3}},
            maximum_wire_distance = 60,
            supply_area_distance = 0,
            vehicle_impact_sound =  { filename = "__Big Poles__/sound/car-metal-impact.ogg", volume = 0.65 },
            pictures =
            {
                filename = "__base__/graphics/entity/big-electric-pole/big-electric-pole.png",
                priority = "high",
                width = 168,
                height = 165,
                direction_count = 4,
                shift = {1.6, -1.1}
            },
            connection_points =
            {
                {
                    shadow =
                    {
                        copper = {2.7, 0},
                        green = {1.8, 0},
                        red = {3.6, 0}
                    },
                    wire =
                    {
                        copper = {0, -3.125},
                        green = {-0.59375, -3.125},
                        red = {0.625, -3.125}
                    }
                },
                {
                    shadow =
                    {
                        copper = {3.1, 0.2},
                        green = {2.3, -0.3},
                        red = {3.8, 0.6}
                    },
                    wire =
                    {
                        copper = {-0.0625, -3.125},
                        green = {-0.5, -3.4375},
                        red = {0.34375, -2.8125}
                    }
                },
                {
                    shadow =
                    {
                        copper = {2.9, 0.06},
                        green = {3.0, -0.6},
                        red = {3.0, 0.8}
                    },
                    wire =
                    {
                        copper = {-0.09375, -3.09375},
                        green = {-0.09375, -3.53125},
                        red = {-0.09375, -2.65625}
                    }
                },
                {
                    shadow =
                    {
                        copper = {3.1, 0.2},
                        green = {3.8, -0.3},
                        red = {2.35, 0.6}
                    },
                    wire =
                    {
                        copper = {-0.0625, -3.1875},
                        green = {0.375, -3.5},
                        red = {-0.46875, -2.90625}
                    }
                }
            },
            radius_visualisation_picture =
            {
                filename = "__base__/graphics/entity/small-electric-pole/electric-pole-radius-visualization.png",
                width = 12,
                height = 12,
                priority = "extra-high-no-scale"
            },
        },

        --Bigger Electric Pole 2
        {
        type = "electric-pole",
        name = "bigger-electric-pole-2",
        icon = "__base__/graphics/icons/big-electric-pole.png",
        flags = {"placeable-neutral", "player-creation"},
        minable = {hardness = 0.2, mining_time = 0.5, result = "bigger-electric-pole-2"},
        max_health = 150,
        corpse = "medium-remnants",
        resistances =
        {
            {
                type = "fire",
                percent = 100
            }
        },
        collision_box = {{-2.65, -2.65}, {2.65, 2.65}},
        selection_box = {{-3, -3}, {3, 3}},
        drawing_box = {{-1, -3}, {1, 3}},
        maximum_wire_distance = 120,
        supply_area_distance = 0,
        vehicle_impact_sound =  { filename = "__Big Poles__/sound/car-metal-impact.ogg", volume = 0.65 },
        pictures =
        {
            filename = "__base__/graphics/entity/big-electric-pole/big-electric-pole.png",
            priority = "high",
            width = 168,
            height = 165,
            direction_count = 4,
            shift = {1.6, -1.1}
        },
        connection_points =
        {
            {
                shadow =
                {
                    copper = {2.7, 0},
                    green = {1.8, 0},
                    red = {3.6, 0}
                },
                wire =
                {
                    copper = {0, -3.125},
                    green = {-0.59375, -3.125},
                    red = {0.625, -3.125}
                }
            },
            {
                shadow =
                {
                    copper = {3.1, 0.2},
                    green = {2.3, -0.3},
                    red = {3.8, 0.6}
                },
                wire =
                {
                    copper = {-0.0625, -3.125},
                    green = {-0.5, -3.4375},
                    red = {0.34375, -2.8125}
                }
            },
            {
                shadow =
                {
                    copper = {2.9, 0.06},
                    green = {3.0, -0.6},
                    red = {3.0, 0.8}
                },
                wire =
                {
                    copper = {-0.09375, -3.09375},
                    green = {-0.09375, -3.53125},
                    red = {-0.09375, -2.65625}
                }
            },
            {
                shadow =
                {
                    copper = {3.1, 0.2},
                    green = {3.8, -0.3},
                    red = {2.35, 0.6}
                },
                wire =
                {
                    copper = {-0.0625, -3.1875},
                    green = {0.375, -3.5},
                    red = {-0.46875, -2.90625}
                }
            }
        },
        radius_visualisation_picture =
        {
            filename = "__base__/graphics/entity/small-electric-pole/electric-pole-radius-visualization.png",
            width = 12,
            height = 12,
            priority = "extra-high-no-scale"
        },
    },

        --Bigger Electric Pole 3
        {
            type = "electric-pole",
            name = "bigger-electric-pole-3",
            icon = "__base__/graphics/icons/big-electric-pole.png",
            flags = {"placeable-neutral", "player-creation"},
            minable = {hardness = 0.2, mining_time = 0.5, result = "bigger-electric-pole-3"},
            max_health = 150,
            corpse = "medium-remnants",
            resistances =
            {
                {
                    type = "fire",
                    percent = 100
                }
            },
            collision_box = {{-3.65, -3.65}, {3.65, 3.65}},
            selection_box = {{-4, -4}, {4, 4}},
            drawing_box = {{-1, -3}, {1, 3}},
            maximum_wire_distance = 240,
            supply_area_distance = 0,
            vehicle_impact_sound =  { filename = "__Big Poles__/sound/car-metal-impact.ogg", volume = 0.65 },
            pictures =
            {
                filename = "__base__/graphics/entity/big-electric-pole/big-electric-pole.png",
                priority = "high",
                width = 168,
                height = 165,
                direction_count = 4,
                shift = {1.6, -1.1}
            },
            connection_points =
            {
                {
                    shadow =
                    {
                        copper = {2.7, 0},
                        green = {1.8, 0},
                        red = {3.6, 0}
                    },
                    wire =
                    {
                        copper = {0, -3.125},
                        green = {-0.59375, -3.125},
                        red = {0.625, -3.125}
                    }
                },
                {
                    shadow =
                    {
                        copper = {3.1, 0.2},
                        green = {2.3, -0.3},
                        red = {3.8, 0.6}
                    },
                    wire =
                    {
                        copper = {-0.0625, -3.125},
                        green = {-0.5, -3.4375},
                        red = {0.34375, -2.8125}
                    }
                },
                {
                    shadow =
                    {
                        copper = {2.9, 0.06},
                        green = {3.0, -0.6},
                        red = {3.0, 0.8}
                    },
                    wire =
                    {
                        copper = {-0.09375, -3.09375},
                        green = {-0.09375, -3.53125},
                        red = {-0.09375, -2.65625}
                    }
                },
                {
                    shadow =
                    {
                        copper = {3.1, 0.2},
                        green = {3.8, -0.3},
                        red = {2.35, 0.6}
                    },
                    wire =
                    {
                        copper = {-0.0625, -3.1875},
                        green = {0.375, -3.5},
                        red = {-0.46875, -2.90625}
                    }
                }
            },
            radius_visualisation_picture =
            {
                filename = "__base__/graphics/entity/small-electric-pole/electric-pole-radius-visualization.png",
                width = 12,
                height = 12,
                priority = "extra-high-no-scale"
            },
        },

        --Bigger Electric Pole 4
        {
            type = "electric-pole",
            name = "bigger-electric-pole-4",
            icon = "__base__/graphics/icons/big-electric-pole.png",
            flags = {"placeable-neutral", "player-creation"},
            minable = {hardness = 0.2, mining_time = 0.5, result = "bigger-electric-pole-4"},
            max_health = 150,
            corpse = "medium-remnants",
            resistances =
            {
                {
                    type = "fire",
                    percent = 100
                }
            },
            collision_box = {{-4.65, -4.65}, {4.65, 4.65}},
            selection_box = {{-5, -5}, {5, 5}},
            drawing_box = {{-1, -3}, {1, 3}},
            maximum_wire_distance = 480,
            supply_area_distance = 0,
            vehicle_impact_sound =  { filename = "__Big Poles__/sound/car-metal-impact.ogg", volume = 0.65 },
            pictures =
            {
                filename = "__base__/graphics/entity/big-electric-pole/big-electric-pole.png",
                priority = "high",
                width = 168,
                height = 165,
                direction_count = 4,
                shift = {1.6, -1.1}
            },
            connection_points =
            {
                {
                    shadow =
                    {
                        copper = {2.7, 0},
                        green = {1.8, 0},
                        red = {3.6, 0}
                    },
                    wire =
                    {
                        copper = {0, -3.125},
                        green = {-0.59375, -3.125},
                        red = {0.625, -3.125}
                    }
                },
                {
                    shadow =
                    {
                        copper = {3.1, 0.2},
                        green = {2.3, -0.3},
                        red = {3.8, 0.6}
                    },
                    wire =
                    {
                        copper = {-0.0625, -3.125},
                        green = {-0.5, -3.4375},
                        red = {0.34375, -2.8125}
                    }
                },
                {
                    shadow =
                    {
                        copper = {2.9, 0.06},
                        green = {3.0, -0.6},
                        red = {3.0, 0.8}
                    },
                    wire =
                    {
                        copper = {-0.09375, -3.09375},
                        green = {-0.09375, -3.53125},
                        red = {-0.09375, -2.65625}
                    }
                },
                {
                    shadow =
                    {
                        copper = {3.1, 0.2},
                        green = {3.8, -0.3},
                        red = {2.35, 0.6}
                    },
                    wire =
                    {
                        copper = {-0.0625, -3.1875},
                        green = {0.375, -3.5},
                        red = {-0.46875, -2.90625}
                    }
                }
            },
            radius_visualisation_picture =
            {
                filename = "__base__/graphics/entity/small-electric-pole/electric-pole-radius-visualization.png",
                width = 12,
                height = 12,
                priority = "extra-high-no-scale"
            },
        },
    }
)

