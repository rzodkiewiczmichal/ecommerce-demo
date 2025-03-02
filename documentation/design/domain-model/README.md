# Domain Model Documentation

The domain model for our e-commerce system is documented using PlantUML diagrams. These diagrams are split into two files:

1. `domain-model-aggregates.puml`: Contains the entities and aggregates of the domain model.
2. `domain-model-value-objects.puml`: Contains the value objects of the domain model.

## Viewing the Diagrams

To convert the PlantUML files to SVG format for easy viewing, use the following command:

```
plantuml -tsvg ./documentation/design/domain-model/*.puml
```

This command will generate SVG files in the same directory as the PlantUML files.

## Updating the Model

When making changes to the domain model:

1. Edit the appropriate `.puml` file(s).
2. Run the conversion command to update the SVG files.
3. Commit both the `.puml` and `.svg` files to the repository.

Remember to keep the PlantUML diagrams and their SVG renderings in sync with any changes in the domain model implementation.
